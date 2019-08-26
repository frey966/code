package com.bfw.manage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bfw.common.annotation.DataSource;
import com.bfw.common.enums.DataSourceType;
import com.bfw.manage.domain.MatchListBean;
import com.bfw.manage.domain.TeamInfoCategory;
import com.bfw.manage.mapper.IMatchMapper;
import com.bfw.manage.service.IMatchService;
import com.bfw.manage.utils.LogoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author study
 * @date 2019年08月11日
 */
@Service
@Slf4j
public class MatchServiceImpl implements IMatchService {

    @Autowired
    private IMatchMapper matchDao;

    /*未开始*/
    private static final String UN_COMMING="1";
    /*进行中*/
    private static final String COMMING="2";
    /*已结束*/
    private static final String FINISH="3";

    @Override
    @DataSource(DataSourceType.SLAVE)
    public List<MatchListBean> index(Integer status,String match_data,Integer sport_type)  {
       return matchDao.queryMatchList(status,match_data,sport_type);
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public JSONObject getDetail(long match_id) {
        JSONObject result = matchDao.getDetail(match_id);
        if (result==null){
            log.info("ID：{}查询结果为空",match_id);
            return null;
        }
        String status_text=(String)result.get("status_text");
        result.put("home_team_logo",LogoUtils.getLogoByUrl((String)result.get("home_team_logo")));
        result.put("away_team_logo",LogoUtils.getLogoByUrl((String)result.get("away_team_logo")));
        switch (status_text){
            case UN_COMMING:
                result.put("status_text","未开始");
                break;
            case COMMING:
                result.put("status_text","进行中");
                break;
            case FINISH:
                result.put("status_text","已完成");
                break;
            default:
                break;
        }
        return result;
    }

    @Override
    @DataSource(DataSourceType.SLAVE)
    public List<TeamInfoCategory> getTeam(long id, String type) {
        List<TeamInfoCategory> list = matchDao.getTeam(id, type);
        for (TeamInfoCategory teamInfoCategory:list) {
            teamInfoCategory.setLogo_url(LogoUtils.getLogoByUrl(teamInfoCategory.getLogo_url()));
        }
        return list;
    }
}
