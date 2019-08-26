package com.bfw.manage.service;

import com.bfw.manage.domain.JmfTopicCategory;
import java.util.List;

/**
 * 话题一级分类Service接口
 * 
 * @author barkley
 * @date 2019-08-14
 */
public interface IJmfTopicCategoryService 
{
    /**
     * 查询话题一级分类
     * 
     * @param id 话题一级分类ID
     * @return 话题一级分类
     */
    public JmfTopicCategory selectJmfTopicCategoryById(Integer id);

    /**
     * 查询话题一级分类列表
     * 
     * @param jmfTopicCategory 话题一级分类
     * @return 话题一级分类集合
     */
    public List<JmfTopicCategory> selectJmfTopicCategoryList(JmfTopicCategory jmfTopicCategory);

    /**
     * 新增话题一级分类
     * 
     * @param jmfTopicCategory 话题一级分类
     * @return 结果
     */
    public int insertJmfTopicCategory(JmfTopicCategory jmfTopicCategory);

    /**
     * 修改话题一级分类
     * 
     * @param jmfTopicCategory 话题一级分类
     * @return 结果
     */
    public int updateJmfTopicCategory(JmfTopicCategory jmfTopicCategory);

    /**
     * 批量删除话题一级分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmfTopicCategoryByIds(String ids);

    /**
     * 删除话题一级分类信息
     * 
     * @param id 话题一级分类ID
     * @return 结果
     */
    public int deleteJmfTopicCategoryById(Integer id);
}
