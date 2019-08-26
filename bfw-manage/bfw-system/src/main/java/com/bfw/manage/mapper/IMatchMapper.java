package com.bfw.manage.mapper;

import com.alibaba.fastjson.JSONObject;
import com.bfw.manage.domain.MatchListBean;
import com.bfw.manage.domain.TeamInfoCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author study
 * @date 2019年08月12日
 */
@Mapper
@Component
public interface IMatchMapper {

    List<MatchListBean> queryMatchList(@Param("status") Integer status,
                                       @Param("match_data")String match_data,
                                       @Param("sport_type")Integer sport_type);

    JSONObject getDetail(@Param("match_id") long match_id);

    List<TeamInfoCategory> getTeam(@Param("id") long id, @Param("type") String type);
}
