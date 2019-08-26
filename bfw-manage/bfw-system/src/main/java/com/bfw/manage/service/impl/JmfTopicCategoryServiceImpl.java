package com.bfw.manage.service.impl;

import java.util.List;

import com.bfw.common.annotation.DataSource;
import com.bfw.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bfw.manage.mapper.JmfTopicCategoryMapper;
import com.bfw.manage.domain.JmfTopicCategory;
import com.bfw.manage.service.IJmfTopicCategoryService;
import com.bfw.common.core.text.Convert;

/**
 * 话题一级分类Service业务层处理
 * 
 * @author barkley
 * @date 2019-08-14
 */
@Service
public class JmfTopicCategoryServiceImpl implements IJmfTopicCategoryService 
{
    @Autowired
    private JmfTopicCategoryMapper jmfTopicCategoryMapper;

    /**
     * 查询话题一级分类
     * 
     * @param id 话题一级分类ID
     * @return 话题一级分类
     */
    @Override
    public JmfTopicCategory selectJmfTopicCategoryById(Integer id)
    {
        return jmfTopicCategoryMapper.selectJmfTopicCategoryById(id);
    }

    /**
     * 查询话题一级分类列表
     * 
     * @param jmfTopicCategory 话题一级分类
     * @return 话题一级分类
     */
    @DataSource(DataSourceType.DB2)
    @Override
    public List<JmfTopicCategory> selectJmfTopicCategoryList(JmfTopicCategory jmfTopicCategory)
    {
        return jmfTopicCategoryMapper.selectJmfTopicCategoryList(jmfTopicCategory);
    }

    /**
     * 新增话题一级分类
     * 
     * @param jmfTopicCategory 话题一级分类
     * @return 结果
     */
    @Override
    public int insertJmfTopicCategory(JmfTopicCategory jmfTopicCategory)
    {
        return jmfTopicCategoryMapper.insertJmfTopicCategory(jmfTopicCategory);
    }

    /**
     * 修改话题一级分类
     * 
     * @param jmfTopicCategory 话题一级分类
     * @return 结果
     */
    @Override
    public int updateJmfTopicCategory(JmfTopicCategory jmfTopicCategory)
    {
        return jmfTopicCategoryMapper.updateJmfTopicCategory(jmfTopicCategory);
    }

    /**
     * 删除话题一级分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJmfTopicCategoryByIds(String ids)
    {
        return jmfTopicCategoryMapper.deleteJmfTopicCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除话题一级分类信息
     * 
     * @param id 话题一级分类ID
     * @return 结果
     */
    public int deleteJmfTopicCategoryById(Integer id)
    {
        return jmfTopicCategoryMapper.deleteJmfTopicCategoryById(id);
    }
}
