package com.bfw.manage.domain;

import com.bfw.common.annotation.Excel;
import com.bfw.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 话题一级分类对象 jmf_topic_category
 * 
 * @author barkley
 * @date 2019-08-14
 */
public class JmfTopicCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Integer id;

    /** 话题分类 */
    @Excel(name = "话题分类")
    private String name;

    /** 创建者 */
    @Excel(name = "创建者")
    private Long createdId;

    /** 1显示0隐藏 */
    @Excel(name = "1显示0隐藏")
    private Integer display;

    /** 排序值，升序，从1开始加 */
    @Excel(name = "排序值，升序，从1开始加")
    private Long sort;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    /** 1正常0删除 */
    @Excel(name = "1正常0删除")
    private Integer status;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCreatedId(Long createdId) 
    {
        this.createdId = createdId;
    }

    public Long getCreatedId() 
    {
        return createdId;
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
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("createdId", getCreatedId())
            .append("display", getDisplay())
            .append("sort", getSort())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .append("status", getStatus())
            .toString();
    }
}
