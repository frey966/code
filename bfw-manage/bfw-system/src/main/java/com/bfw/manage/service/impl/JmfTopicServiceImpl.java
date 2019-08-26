package com.bfw.manage.service.impl;

import java.util.List;

import com.bfw.manage.domain.JmfTopic;
import com.bfw.manage.domain.JmfTopicExt;
import com.bfw.manage.mapper.JmfTopicMapper;
import com.bfw.manage.service.IJmfTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bfw.common.core.text.Convert;

/**
 * 话题一级分类Service业务层处理
 * 
 * @author sailboat
 * @date 2019-08-15
 */
@Service
public class JmfTopicServiceImpl implements IJmfTopicService
{
    @Autowired
    private JmfTopicMapper jmfTopicMapper;

    /**
     * 查询话题一级分类
     * 
     * @param id 话题一级分类ID
     * @return 话题一级分类
     */
    @Override
    public JmfTopic selectJmfTopicById(Integer id)
    {
        return jmfTopicMapper.selectJmfTopicById(id);
    }

    /**
     * 查询话题一级分类列表
     * 
     * @param jmfTopic 话题一级分类
     * @return 话题一级分类
     */
    @Override
    public List<JmfTopicExt> selectJmfTopicList(JmfTopic jmfTopic)
    {
        return jmfTopicMapper.selectJmfTopicList(jmfTopic);
    }

    /**
     * 新增话题一级分类
     * 
     * @param jmfTopic 话题一级分类
     * @return 结果
     */
    @Override
    public int insertJmfTopic(JmfTopic jmfTopic)
    {
        return jmfTopicMapper.insertJmfTopic(jmfTopic);
    }

    /**
     * 修改话题一级分类
     * 
     * @param jmfTopic 话题一级分类
     * @return 结果
     */
    @Override
    public int updateJmfTopic(JmfTopic jmfTopic)
    {
        return jmfTopicMapper.updateJmfTopic(jmfTopic);
    }

    /**
     * 删除话题一级分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJmfTopicByIds(String ids)
    {
        return jmfTopicMapper.deleteJmfTopicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除话题一级分类信息
     * 
     * @param id 话题一级分类ID
     * @return 结果
     */
    public int deleteJmfTopicById(Integer id)
    {
        return jmfTopicMapper.deleteJmfTopicById(id);
    }
}
