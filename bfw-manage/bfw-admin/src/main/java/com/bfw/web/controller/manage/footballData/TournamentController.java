package com.bfw.web.controller.manage.footballData;

import java.util.List;

import com.bfw.manage.domain.CategoryExt;
import com.bfw.manage.domain.HotTournamentExt;
import com.bfw.manage.domain.TournamentExt;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bfw.common.annotation.Log;
import com.bfw.common.enums.BusinessType;
import com.bfw.manage.domain.HotTournament;
import com.bfw.manage.service.IHotTournamentService;
import com.bfw.common.core.controller.BaseController;
import com.bfw.common.core.domain.AjaxResult;
import com.bfw.common.core.page.TableDataInfo;

/**
 * 热门赛事Controller
 * 
 * @author barkley
 * @date 2019-08-15
 */
@Controller
@RequestMapping("/manage/tournament")
public class TournamentController extends BaseController
{
    @Autowired
    private IHotTournamentService hotTournamentService;

    /**
     * 查询热门赛事列表
     */
    @RequiresPermissions("manage:tournament:list")
    @PostMapping("/hotList")
    @ResponseBody
    public TableDataInfo hotList(HotTournament hotTournament)
    {
//        startPage();
        List<HotTournamentExt> list = hotTournamentService.selectHotList(hotTournament);
        return getDataTable(list);
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HotTournament hotTournament)
    {
//        startPage();
        List<HotTournament> list = hotTournamentService.selectHotTournamentList(hotTournament);
        return getDataTable(list);
    }

    @PostMapping("/categoryList")
    @ResponseBody
    public TableDataInfo categoryList(String continent)
    {
        List<CategoryExt> list = hotTournamentService.selectCategoryList(continent);
        return getDataTable(list);
    }

    @PostMapping("/tournamentList")
    @ResponseBody
    public TableDataInfo tournamentList(Integer categoryId)
    {
        List<TournamentExt> list = hotTournamentService.selectTournamentList(categoryId);
        return getDataTable(list);
    }

    /**
     * 新增保存热门赛事
     */
    @RequiresPermissions("manage:tournament:add")
    @Log(title = "热门赛事", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HotTournament hotTournament)
    {
        return toAjax(hotTournamentService.insertHotTournament(hotTournament));
    }

    /**
     * 修改保存热门赛事
     */
    @RequiresPermissions("manage:tournament:edit")
    @Log(title = "热门赛事", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HotTournament hotTournament)
    {
        return toAjax(hotTournamentService.updateHotTournament(hotTournament));
    }

    /**
     * 删除热门赛事
     */
    @RequiresPermissions("manage:tournament:remove")
    @Log(title = "热门赛事", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(hotTournamentService.deleteHotTournamentByIds(ids));
    }
}
