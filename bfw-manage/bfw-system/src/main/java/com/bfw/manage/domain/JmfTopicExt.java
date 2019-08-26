package com.bfw.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 话题一级分类对象 jmf_topic
 * 
 * @author sailboat
 * @date 2019-08-15
 */
public class JmfTopicExt
{
    private Integer id;

    private Long topicCategoryId;

    private String logoUrl;

    private String title;

    private String describe;

    private Integer display;

    private Long sort;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("topicCategoryId", getTopicCategoryId())
            .append("logoUrl", getLogoUrl())
            .append("title", getTitle())
            .append("describe", getDescribe())
            .append("display", getDisplay())
            .append("sort", getSort())
            .append("status", getStatus())
            .toString();
    }
}
