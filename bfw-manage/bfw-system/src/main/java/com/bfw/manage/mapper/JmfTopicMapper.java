package com.bfw.manage.mapper;

import com.bfw.manage.domain.JmfTopic;
import com.bfw.manage.domain.JmfTopicExt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 话题一级分类Mapper接口
 * 
 * @author sailboat
 * @date 2019-08-15
 */
@Mapper
public interface JmfTopicMapper 
{
    /**
     * 查询话题一级分类
     * 
     * @param id 话题一级分类ID
     * @return 话题一级分类
     */
    public JmfTopic selectJmfTopicById(Integer id);

    /**
     * 查询话题一级分类列表
     * 
     * @param jmfTopic 话题一级分类
     * @return 话题一级分类集合
     */
    public List<JmfTopicExt> selectJmfTopicList(JmfTopic jmfTopic);

    /**
     * 新增话题一级分类
     * 
     * @param jmfTopic 话题一级分类
     * @return 结果
     */
    public int insertJmfTopic(JmfTopic jmfTopic);

    /**
     * 修改话题一级分类
     * 
     * @param jmfTopic 话题一级分类
     * @return 结果
     */
    public int updateJmfTopic(JmfTopic jmfTopic);

    /**
     * 删除话题一级分类
     * 
     * @param id 话题一级分类ID
     * @return 结果
     */
    public int deleteJmfTopicById(Integer id);

    /**
     * 批量删除话题一级分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmfTopicByIds(String[] ids);
}
