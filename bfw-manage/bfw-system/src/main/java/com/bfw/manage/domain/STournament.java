package com.bfw.manage.domain;

import com.bfw.common.annotation.Excel;
import com.bfw.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 联赛信息对象 s_tournament
 * 
 * @author barkley
 * @date 2019-08-15
 */
public class STournament extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 赛事ID */
    private Long id;

    /** 赛事类型ID */
    @Excel(name = "赛事类型ID")
    private Long sportId;

    /** 区域分类ID */
    @Excel(name = "区域分类ID")
    private Long categoryId;

    /** 当前赛季ID */
    @Excel(name = "当前赛季ID")
    private Long currentSeasonId;

    /** 中文全称 */
    @Excel(name = "中文全称")
    private String cnName;

    /** 中文简称 */
    @Excel(name = "中文简称")
    private String cnAlias;

    /** 英文全称 */
    @Excel(name = "英文全称")
    private String enName;

    /** 英文简称 */
    @Excel(name = "英文简称")
    private String enAlias;

    /** LOGO地址 */
    @Excel(name = "LOGO地址")
    private String logoUrl;

    /** 类别，1联赛，2杯赛 */
    @Excel(name = "类别，1联赛，2杯赛")
    private Integer type;

    /** 分节类型，2上下半场，4四小节 */
    @Excel(name = "分节类型，2上下半场，4四小节")
    private Long periodType;

    /** 级别 */
    @Excel(name = "级别")
    private Long level;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 是否完成匹配 */
    @Excel(name = "是否完成匹配")
    private Integer isMatched;

    /** 是否已导入数据 */
    @Excel(name = "是否已导入数据")
    private Integer isImported;

    /** 是否手动更新 */
    @Excel(name = "是否手动更新")
    private Integer isManualUpdate;

    /** 直播数据源 */
    @Excel(name = "直播数据源")
    private Integer liveSource;

    /** 赔率数据源 */
    @Excel(name = "赔率数据源")
    private Integer oddsSource;

    /** 统计数据源 */
    @Excel(name = "统计数据源")
    private Integer statisticsSource;

    /** 分销等级：1级 2级 */
    @Excel(name = "分销等级：1级 2级")
    private Integer shareLevel;

    /** $column.columnComment */
    @Excel(name = "分销等级：1级 2级")
    private Integer ishot;

    /** $column.columnComment */
    @Excel(name = "分销等级：1级 2级")
    private String newlogo;

    /** $column.columnComment */
    @Excel(name = "分销等级：1级 2级")
    private Long xmId;

    /** $column.columnComment */
    @Excel(name = "分销等级：1级 2级", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dataUpdateTime;

    /** $column.columnComment */
    @Excel(name = "分销等级：1级 2级", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dataCreateTime;

    /** 联赛对应的颜色RGB值 */
    @Excel(name = "联赛对应的颜色RGB值")
    private String color;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSportId(Long sportId) 
    {
        this.sportId = sportId;
    }

    public Long getSportId() 
    {
        return sportId;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setCurrentSeasonId(Long currentSeasonId) 
    {
        this.currentSeasonId = currentSeasonId;
    }

    public Long getCurrentSeasonId() 
    {
        return currentSeasonId;
    }
    public void setCnName(String cnName) 
    {
        this.cnName = cnName;
    }

    public String getCnName() 
    {
        return cnName;
    }
    public void setCnAlias(String cnAlias) 
    {
        this.cnAlias = cnAlias;
    }

    public String getCnAlias() 
    {
        return cnAlias;
    }
    public void setEnName(String enName) 
    {
        this.enName = enName;
    }

    public String getEnName() 
    {
        return enName;
    }
    public void setEnAlias(String enAlias) 
    {
        this.enAlias = enAlias;
    }

    public String getEnAlias() 
    {
        return enAlias;
    }
    public void setLogoUrl(String logoUrl) 
    {
        this.logoUrl = logoUrl;
    }

    public String getLogoUrl() 
    {
        return logoUrl;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setPeriodType(Long periodType) 
    {
        this.periodType = periodType;
    }

    public Long getPeriodType() 
    {
        return periodType;
    }
    public void setLevel(Long level) 
    {
        this.level = level;
    }

    public Long getLevel() 
    {
        return level;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setIsMatched(Integer isMatched) 
    {
        this.isMatched = isMatched;
    }

    public Integer getIsMatched() 
    {
        return isMatched;
    }
    public void setIsImported(Integer isImported) 
    {
        this.isImported = isImported;
    }

    public Integer getIsImported() 
    {
        return isImported;
    }
    public void setIsManualUpdate(Integer isManualUpdate) 
    {
        this.isManualUpdate = isManualUpdate;
    }

    public Integer getIsManualUpdate() 
    {
        return isManualUpdate;
    }
    public void setLiveSource(Integer liveSource) 
    {
        this.liveSource = liveSource;
    }

    public Integer getLiveSource() 
    {
        return liveSource;
    }
    public void setOddsSource(Integer oddsSource) 
    {
        this.oddsSource = oddsSource;
    }

    public Integer getOddsSource() 
    {
        return oddsSource;
    }
    public void setStatisticsSource(Integer statisticsSource) 
    {
        this.statisticsSource = statisticsSource;
    }

    public Integer getStatisticsSource() 
    {
        return statisticsSource;
    }
    public void setShareLevel(Integer shareLevel) 
    {
        this.shareLevel = shareLevel;
    }

    public Integer getShareLevel() 
    {
        return shareLevel;
    }
    public void setIshot(Integer ishot) 
    {
        this.ishot = ishot;
    }

    public Integer getIshot() 
    {
        return ishot;
    }
    public void setNewlogo(String newlogo) 
    {
        this.newlogo = newlogo;
    }

    public String getNewlogo() 
    {
        return newlogo;
    }
    public void setXmId(Long xmId) 
    {
        this.xmId = xmId;
    }

    public Long getXmId() 
    {
        return xmId;
    }
    public void setDataUpdateTime(Date dataUpdateTime) 
    {
        this.dataUpdateTime = dataUpdateTime;
    }

    public Date getDataUpdateTime() 
    {
        return dataUpdateTime;
    }
    public void setDataCreateTime(Date dataCreateTime) 
    {
        this.dataCreateTime = dataCreateTime;
    }

    public Date getDataCreateTime() 
    {
        return dataCreateTime;
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public String getColor() 
    {
        return color;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sportId", getSportId())
            .append("categoryId", getCategoryId())
            .append("currentSeasonId", getCurrentSeasonId())
            .append("cnName", getCnName())
            .append("cnAlias", getCnAlias())
            .append("enName", getEnName())
            .append("enAlias", getEnAlias())
            .append("logoUrl", getLogoUrl())
            .append("type", getType())
            .append("periodType", getPeriodType())
            .append("level", getLevel())
            .append("description", getDescription())
            .append("isMatched", getIsMatched())
            .append("isImported", getIsImported())
            .append("isManualUpdate", getIsManualUpdate())
            .append("liveSource", getLiveSource())
            .append("oddsSource", getOddsSource())
            .append("statisticsSource", getStatisticsSource())
            .append("shareLevel", getShareLevel())
            .append("updateTime", getUpdateTime())
            .append("ishot", getIshot())
            .append("newlogo", getNewlogo())
            .append("xmId", getXmId())
            .append("dataUpdateTime", getDataUpdateTime())
            .append("dataCreateTime", getDataCreateTime())
            .append("color", getColor())
            .toString();
    }
}
