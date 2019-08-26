package com.bfw.web.controller.manage.jmfTopic;

import java.util.List;

import com.bfw.manage.domain.JmfTopic;
import com.bfw.manage.domain.JmfTopicExt;
import com.bfw.manage.service.IJmfTopicService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bfw.common.annotation.Log;
import com.bfw.common.enums.BusinessType;
import com.bfw.common.core.controller.BaseController;
import com.bfw.common.core.domain.AjaxResult;
import com.bfw.common.core.page.TableDataInfo;

/**
 * 话题一级分类Controller
 * 
 * @author barkley
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/manage/topic")
public class JmfTopicController extends BaseController
{
    @Autowired
    private IJmfTopicService jmfTopicService;

    /**
     * 查询话题一级分类列表
     */
    @RequiresPermissions("manage:topic:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JmfTopic jmfTopic)
    {
//        startPage();
        List<JmfTopicExt> list = jmfTopicService.selectJmfTopicList(jmfTopic);
        return getDataTable(list);
    }

    /**
     * 新增保存话题一级分类
     */
    @RequiresPermissions("manage:topic:add")
    @Log(title = "话题一级分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JmfTopic jmfTopic)
    {
        return toAjax(jmfTopicService.insertJmfTopic(jmfTopic));
    }

    /**
     * 修改保存话题一级分类
     */
    @RequiresPermissions("manage:topic:edit")
    @Log(title = "话题一级分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JmfTopic jmfTopic)
    {
        return toAjax(jmfTopicService.updateJmfTopic(jmfTopic));
    }

    /**
     * 删除话题一级分类
     */
    @RequiresPermissions("manage:topic:remove")
    @Log(title = "话题一级分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jmfTopicService.deleteJmfTopicByIds(ids));
    }
}
