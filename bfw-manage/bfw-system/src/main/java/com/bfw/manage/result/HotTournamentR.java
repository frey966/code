package com.bfw.manage.result;

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
public class HotTournamentR extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 热门赛事ID */
    private Long hotId;

    /** 赛事ID */
    @Excel(name = "赛事ID")
    private Long tournamentId;

    /** 1显示 0隐藏 */
    @Excel(name = "1显示 0隐藏")
    private Integer display;

    /** 排序值 */
    @Excel(name = "排序值")
    private Long sort;

    /** 1正常 0删除 */
    @Excel(name = "1正常 0删除")
    private Integer status;

    /** 1pc 2app */
    @Excel(name = "1pc 2app")
    private Integer origin;

    /** 1足球 2篮球 */
    @Excel(name = "1足球 2篮球")
    private Integer type;

    /** $column.columnComment */
    @Excel(name = "1足球 2篮球", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** $column.columnComment */
    @Excel(name = "1足球 2篮球", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setHotId(Long hotId) 
    {
        this.hotId = hotId;
    }

    public Long getHotId() 
    {
        return hotId;
    }
    public void setTournamentId(Long tournamentId) 
    {
        this.tournamentId = tournamentId;
    }

    public Long getTournamentId() 
    {
        return tournamentId;
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
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hotId", getHotId())
            .append("tournamentId", getTournamentId())
            .append("display", getDisplay())
            .append("sort", getSort())
            .append("status", getStatus())
            .append("origin", getOrigin())
            .append("type", getType())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
