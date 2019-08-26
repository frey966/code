package com.bfw.manage.domain;

import lombok.Data;

/**
 * @author study
 * @date 2019年08月12日
 */
@Data
public class MatchListBean {
    private int id;
    private String match_time;
    private String tournament_id;
    private int status;
    private int status_code;
    private String status_name;
    private int time_played;
    private int home_team_id;
    private int away_team_id;
    private String home_team_name;
    private String away_team_name;
    private int home_team_score;
    private int away_team_score;
    private String round;
    private String round_type;
    private String home_team_logo;
    private String away_team_logo;
    private String match_info;
    private HomeTeam home_team;
    private AwayTeam away_team;
    private TeamInfo team_info;
    @Data
    public static class HomeTeam{
        private int id;
        private String logo_url;
    }
    @Data
    public static class AwayTeam{
        private int id;
        private String logo_url;
    }
    @Data
    public static class TeamInfo{
        private int id;
        private String cn_name;
        private String cn_alias;
    }
}
