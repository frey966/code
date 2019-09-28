package cn.jmfen.backend.user.service.impl;

import cn.jmfen.backend.common.config.ApiUrl;
import cn.jmfen.backend.common.domain.FebsConstant;
import cn.jmfen.backend.common.domain.QueryRequest;
import cn.jmfen.backend.common.utils.RestTemplateUtil;
import cn.jmfen.backend.common.utils.SortUtil;
import cn.jmfen.backend.common.utils.StringUtils;
import cn.jmfen.backend.user.dao.JmfSysUserMapper;
import cn.jmfen.backend.user.doman.JmfSysUser;
import cn.jmfen.backend.user.doman.JmfSysUserExt;
import cn.jmfen.backend.user.query.AnchorApply;
import cn.jmfen.backend.user.query.AnchorStart;
import cn.jmfen.backend.user.query.AnchorStop;
import cn.jmfen.backend.user.query.JmfUserQuery;
import cn.jmfen.backend.user.result.JmfUserResult;
import cn.jmfen.backend.user.service.IJmfSysUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Barkley
 */
@Slf4j
@Service
public class JmfSysUserServiceImpl extends ServiceImpl<JmfSysUserMapper, JmfSysUser> implements IJmfSysUserService {
    @Autowired
    private JmfSysUserMapper jmfSysUserMapper;

    @Autowired
    private ApiUrl apiUrl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${live-api}")
    private String liveUrl;

    @Override
    @DS("db1")
    public IPage<JmfUserResult> userList(JmfUserQuery user, QueryRequest queryRequest) {
        long start = System.currentTimeMillis();
        try {
            Page<JmfUserResult> page = new Page<>();
            SortUtil.handlePageSort(queryRequest, page, "create_time", FebsConstant.ORDER_DESC, false);
            user.setStart(queryRequest.getPageSize()*(queryRequest.getPageNum()-1));
            user.setEnd(queryRequest.getPageSize());
            long start1 = System.currentTimeMillis();
            IPage<JmfUserResult> data = jmfSysUserMapper.selectList(page, user);
            long end = System.currentTimeMillis();
            log.info("---注册用户查询---"+(end-start1)+"ms");
            log.info("---注册用户查询total---"+(end-start)+"ms");
            return data;
        } catch (Exception e) {
            log.error("查询用户管理列表异常", e);
            return null;
        }
    }

    @Override
    @DS("db1")
    @Transactional
    public JmfUserResult selectById(Long id) {
        String result = RestTemplateUtil.getForJson(liveUrl + "/v1/anchors/anchorDetailById?userId="+id);
        JSONObject json = JSONObject.parseObject(result);
        JmfSysUser _user = new JmfSysUser();
        _user.setId(id);
        if(json.containsKey("code")&&json.getString("code").equals("200")) {
            if (null != json.getString("data")) {
                _user.setIsAnchor(1);
            } else {
                _user.setIsAnchor(0);
            }
            _user.setUpdateTime(new Date());
            jmfSysUserMapper.updateById(_user);
        }
        return jmfSysUserMapper.getUserById(id);
    }

    @Override
    @Transactional
    @DS("db1")
    public Boolean updateUser(JmfSysUserExt user) {
        if(StringUtils.isNotEmpty(user.getNickname())){
            JmfUserResult _user = jmfSysUserMapper.getUserById(user.getId());
            if(!_user.getNickname().equals(user.getNickname())){
                checkNickName(user);
            }
        }
        user.setUpdateTime(new Date());
        //新密码
        if(StringUtils.isNotEmpty(user.getNewPassword())){
            if(StringUtils.isEmpty(user.getPassword())){
                throw new RuntimeException("请输入原密码!");
            }
            JmfUserResult _user = jmfSysUserMapper.getUserById(user.getId());
            //原密码验证
            boolean b = passwordEncoder.matches(user.getPassword(),_user.getPassword());
            if(b){
                user.setPassword(passwordEncoder.encode(user.getNewPassword()));
            }else{
                throw new RuntimeException("原密码有误!");
            }
        }
        user.setPersonalDesc(user.getProfile());
        user.setNewPassword(null);
        JmfSysUser _user = new JmfSysUser();
        BeanUtils.copyProperties(user,_user);
        return updateById(_user);
    }

    @Override
    @DS("db1")
    public Boolean addUser(JmfSysUserExt user) {
        // 添加用户
        if(StringUtils.isNotEmpty(user.getMobile())){
            checkMobile(user);
        }
        if(StringUtils.isNotEmpty(user.getNickname())){
            checkNickName(user);
        }
        user.setCreateTime(new Date());
        user.setType("BACKEND");
        String word = null==user.getPassword()?"111111":user.getPassword();
        user.setPassword(passwordEncoder.encode(word));
        user.setCreateTime(new Date());
        JmfSysUser _user = new JmfSysUser();
        BeanUtils.copyProperties(user,_user);
        return this.save(_user);
    }

    @Override
    public String anchorList(AnchorApply anchorApply) {
        Map map = new HashMap();
        map.put("status",null == anchorApply.getStatus()?"":anchorApply.getStatus().toString());
        map.put("mobile",anchorApply.getMobile());
        map.put("pageNum",null == anchorApply.getPageNum()?"1":anchorApply.getPageNum().toString());
        map.put("pageSize",null == anchorApply.getPageSize()?"10":anchorApply.getPageSize().toString());
        String url = RestTemplateUtil.getRequestUrl(apiUrl.getAnchorList(),map);
        return RestTemplateUtil.getForJson(url);
    }

    @Override
    public String anchorUpdate(AnchorApply anchorApply) {

        return RestTemplateUtil.postForJson(apiUrl.getAnchorUpdate(), JSONObject.parseObject(JSONObject.toJSONString(anchorApply)));
    }

    @Override
    @DS("db1")
    public boolean reset(Long id) {
        JmfSysUser user = jmfSysUserMapper.selectById(id);
        user.setUpdateTime(new Date());
        user.setPassword(passwordEncoder.encode("111111"));
        return updateById(user);
    }

    @Override
    @DS("db1")
    public String anchorApply(AnchorApply anchorApply) {
        String result = RestTemplateUtil.postForJson(apiUrl.getAnchorApply(), JSONObject.parseObject(JSONObject.toJSONString(anchorApply)));
        JSONObject json = JSONObject.parseObject(result);
        if(json.containsKey("code")&&json.getString("code").equals("200")){
            JmfSysUserExt user = new JmfSysUserExt();
            user.setId(anchorApply.getUserId());
            user.setIsAnchor(1);
            user.setUpdateTime(new Date());
            JmfSysUser _user = new JmfSysUser();
            BeanUtils.copyProperties(user,_user);
            updateById(_user);
        }else{
            throw new RuntimeException(json.getString("msg"));
        }
        return result;
    }

    @Override
    public String anchorStart(AnchorStart anchorStart) {
        return RestTemplateUtil.postForJson(apiUrl.getAnchorApply(),JSONObject.parseObject(JSONObject.toJSONString(anchorStart)));
    }

    @Override
    public String anchorStop(AnchorStop anchorStop) {
        return RestTemplateUtil.postForJson(apiUrl.getAnchorStop(),JSONObject.parseObject(JSONObject.toJSONString(anchorStop)));
    }

    private void checkNickName(JmfSysUserExt user){
        QueryWrapper<JmfSysUser> nickWrapper = new QueryWrapper<>();
        nickWrapper.eq("nickname", user.getNickname());
        Integer _count = jmfSysUserMapper.selectCount(nickWrapper);
        if(null!=_count&&_count>0){
            throw new RuntimeException("该昵称已存在!");
        }
    }

    private void checkMobile(JmfSysUserExt user){
        QueryWrapper<JmfSysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", user.getMobile());
        Integer count = jmfSysUserMapper.selectCount(queryWrapper);
        if(null!=count&&count>0){
            throw new RuntimeException("该手机号已存在!");
        }
    }

}
