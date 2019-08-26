package com.bfw.web.controller.manage.jmfTopic;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bfw.common.annotation.Log;
import com.bfw.common.enums.BusinessType;
import com.bfw.manage.domain.JmfTopicCategory;
import com.bfw.manage.service.IJmfTopicCategoryService;
import com.bfw.common.core.controller.BaseController;
import com.bfw.common.core.domain.AjaxResult;
import com.bfw.common.core.page.TableDataInfo;

/**
 * 话题一级分类Controller
 * 
 * @author barkley
 * @date 2019-08-14
 */
@Controller
@RequestMapping("/manage/category")
public class JmfTopicCategoryController extends BaseController
{
    @Autowired
    private IJmfTopicCategoryService jmfTopicCategoryService;

    /**
     * 查询话题一级分类列表
     */
    @RequiresPermissions("manage:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JmfTopicCategory jmfTopicCategory)
    {
//        startPage();
        List<JmfTopicCategory> list = jmfTopicCategoryService.selectJmfTopicCategoryList(jmfTopicCategory);
        return getDataTable(list);
    }

    /**
     * 新增保存话题一级分类
     */
    @RequiresPermissions("manage:category:add")
    @Log(title = "话题一级分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JmfTopicCategory jmfTopicCategory)
    {
        return toAjax(jmfTopicCategoryService.insertJmfTopicCategory(jmfTopicCategory));
    }

    /**
     * 修改保存话题一级分类
     */
    @RequiresPermissions("manage:category:edit")
    @Log(title = "话题一级分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JmfTopicCategory jmfTopicCategory)
    {
        return toAjax(jmfTopicCategoryService.updateJmfTopicCategory(jmfTopicCategory));
    }

    /**
     * 删除话题一级分类
     */
    @RequiresPermissions("manage:category:remove")
    @Log(title = "话题一级分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jmfTopicCategoryService.deleteJmfTopicCategoryByIds(ids));
    }
}
