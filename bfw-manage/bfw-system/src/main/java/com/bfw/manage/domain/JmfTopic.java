package com.bfw.manage.domain;

import com.bfw.common.annotation.Excel;
import com.bfw.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 话题一级分类对象 jmf_topic
 * 
 * @author sailboat
 * @date 2019-08-15
 */
public class JmfTopic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 话题分类id */
    @Excel(name = "话题分类id")
    private Long topicCategoryId;

    /** 话题logo */
    @Excel(name = "话题logo")
    private String logoUrl;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 话题描述 */
    @Excel(name = "话题描述")
    private String describe;

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

    /** 1正常 0删除 */
    @Excel(name = "1正常 0删除")
    private Integer status;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setTopicCategoryId(Long topicCategoryId) 
    {
        this.topicCategoryId = topicCategoryId;
    }

    public Long getTopicCategoryId() 
    {
        return topicCategoryId;
    }
    public void setLogoUrl(String logoUrl) 
    {
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() 
    {
        return logoUrl;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDescribe(String describe) 
    {
        this.describe = describe;
    }

    public String getDescribe() 
    {
        return describe;
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
            .append("topicCategoryId", getTopicCategoryId())
            .append("logoUrl", getLogoUrl())
            .append("title", getTitle())
            .append("describe", getDescribe())
            .append("createdId", getCreatedId())
            .append("display", getDisplay())
            .append("sort", getSort())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .append("status", getStatus())
            .toString();
    }
}
