package com.bfw.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bfw.manage.service.IUserService;
import com.bfw.manage.utils.HttpRequestUtil;
import com.bfw.manage.utils.RequestUrlUtils;
import com.bfw.manage.utils.SignUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author study
 * @date 2019年08月10日
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public JSONObject userList(int page, int size, String lockStatus, String regdatetimeStart, String regdatetimeEnd, String searchKey) {
        Map<String,Object> map=new HashMap<>();
        map.put("page",page);
        map.put("size",size);
        putMap("lockStatus",lockStatus,map);
        map.put("appId",3);
        map.put("current",page);
        putMap("regdatetimeStart",regdatetimeStart,map);
        putMap("regdatetimeEnd",regdatetimeEnd,map);
        putMap("searchKey",searchKey,map);
        map.put("sign",getSign(map));
        return JSON.parseObject(HttpRequestUtil.get(RequestUrlUtils.getUserList(),map));
    }

    @Override
    public JSONObject userDetail(long userId) {
        return JSON.parseObject(HttpRequestUtil.get(RequestUrlUtils.getUserDetail()+"/"+userId,null));
    }

    @Override
    public JSONObject userLock(Long userId,int lockdays) {
        Map<String,Object> map=new HashMap<>();
        map.put("lockdays",lockdays);
        return JSON.parseObject(HttpRequestUtil.postForm(RequestUrlUtils.getUserLock()+"/"+userId,map));
    }

    @Override
    public JSONObject userUnLock(Long userId) {
        return JSON.parseObject(HttpRequestUtil.postForm(RequestUrlUtils.getUserUnlock()+"/"+userId,null));
    }

    private String getSign(Map<String,Object> map) {
        return SignUtils.getSign(map);
    }

    private void putMap(String key,Object value,Map<String,Object> map){
        if (value!=null){
            map.put(key,value);
        }
    }
}
