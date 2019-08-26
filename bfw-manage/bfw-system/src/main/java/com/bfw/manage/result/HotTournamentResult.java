package com.bfw.manage.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * 热门赛事对象 hot_tournament
 * 
 * @author barkley
 * @date 2019-08-15
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HotTournamentResult
{
    /** 热门赛事ID */
    private Long hotId;

    /** 赛事ID */
    private String cnName;

    /** 1显示 0隐藏 */
    private Integer display;

    /** 排序值 */
    private Long sort;

    /** 1正常 0删除 */
    private Integer status;

    /** 1pc 2app */
    private Integer origin;

    /** 1足球 2篮球 */
    private Integer type;

}
