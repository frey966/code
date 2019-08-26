package com.bfw.manage.mapper;

import com.bfw.manage.domain.CategoryExt;
import com.bfw.manage.domain.HotTournament;
import com.bfw.manage.domain.HotTournamentExt;
import com.bfw.manage.domain.TournamentExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 热门赛事Mapper接口
 * 
 * @author barkley
 * @date 2019-08-15
 */
public interface HotTournamentMapper 
{
    /**
     * 查询热门赛事
     * 
     * @param hotId 热门赛事ID
     * @return 热门赛事
     */
    public HotTournament selectHotTournamentById(Long hotId);

    /**
     * 查询热门赛事列表
     *
     * @param hotTournament 热门赛事
     * @return 热门赛事集合
     */
    public List<HotTournament> selectHotTournamentList(HotTournament hotTournament);

    public List<HotTournamentExt> selectHotList(HotTournament hotTournament);

    public List<CategoryExt> selectCategoryList(@Param(value="continent") String continent);

    /**
     * 新增热门赛事
     * 
     * @param hotTournament 热门赛事
     * @return 结果
     */
    public int insertHotTournament(HotTournament hotTournament);

    /**
     * 修改热门赛事
     * 
     * @param hotTournament 热门赛事
     * @return 结果
     */
    public int updateHotTournament(HotTournament hotTournament);

    /**
     * 删除热门赛事
     * 
     * @param hotId 热门赛事ID
     * @return 结果
     */
    public int deleteHotTournamentById(Long hotId);

    /**
     * 批量删除热门赛事
     * 
     * @param hotIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotTournamentByIds(String[] hotIds);

    List<TournamentExt> selectTournamentList(Integer categoryId);
}
