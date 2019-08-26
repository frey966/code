package com.bfw.manage.service;


import com.alibaba.fastjson.JSONObject;
import com.bfw.manage.domain.MatchListBean;
import com.bfw.manage.domain.TeamInfoCategory;

import java.util.List;


/**
 * @author study
 * @date 2019年08月11日
 */
public interface IMatchService {
    List<MatchListBean> index(Integer status,String match_data,Integer sport_type);

    JSONObject getDetail(long match_id);

    List<TeamInfoCategory> getTeam(long id, String type);
}
