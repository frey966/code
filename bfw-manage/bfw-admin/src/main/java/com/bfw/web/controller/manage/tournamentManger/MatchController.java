package com.bfw.web.controller.manage.tournamentManger;

import com.bfw.common.core.controller.BaseController;
import com.bfw.common.core.page.TableDataInfo;
import com.bfw.manage.domain.MatchListBean;
import com.bfw.manage.service.IMatchService;
import com.bfw.manage.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author study
 * @date 2019年08月11日
 */
@RestController
@RequestMapping("api/v1/match")
public class MatchController extends BaseController {

    @Autowired
    private IMatchService matchService;

    /**
     * 查询比赛列表
     * @param status
     * @param match_data
     * @param sport_type
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo index(@RequestParam(value = "status",required = false)Integer status,
                @RequestParam(value = "match_data",required = false)String match_data,
                @RequestParam(value = "sport_type",required = false,defaultValue = "1")Integer sport_type ) {
            startPage();// 此方法配合前端完成自动分页
            List<MatchListBean> list=matchService.index(status,match_data,sport_type);
            return getDataTable(list);
    }

    /**
     * 查询单场比赛详情
     * @param match_id
     * @return
     */
    @GetMapping("/detail")
    public Result<Object> getDetail(@RequestParam("match_id")long match_id){
       return Result.buildResult(Result.Status.OK,matchService.getDetail(match_id));
    }

    /**
     * 获取球队信息
     * @param id 球队ID
     * @param type  1足球2篮球
     * @return
     */
    @GetMapping("/team")
    public Result<Object> getTeam(@RequestParam("id")long id,@RequestParam("type")String type){
        return Result.buildResult(Result.Status.OK,matchService.getTeam(id,type));
    }
}
