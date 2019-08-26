package com.bfw.manage.domain;

import com.bfw.common.annotation.Excel;
import com.bfw.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 热门赛事对象 hot_tournament
 * 
 * @author barkley
 * @date 2019-08-15
 */
public class HotTournamentExt
{
    /** 热门赛事ID */
    private Long hotId;

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

    private String cnName;

    public void setHotId(Long hotId)
    {
        this.hotId = hotId;
    }

    public Long getHotId()
    {
        return hotId;
    }

    public void setDisplay(Integer display)
    {
        this.display = display;
    }

    public Integer getDisplay()
    {
        return display;
    }
    public void setSort(Long sort)
    {
        this.sort = sort;
    }

    public Long getSort()
    {
        return sort;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setOrigin(Integer origin)
    {
        this.origin = origin;
    }

    public Integer getOrigin()
    {
        return origin;
    }
    public void setType(Integer type)
    {
        this.type = type;
    }

    public Integer getType()
    {
        return type;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

}
