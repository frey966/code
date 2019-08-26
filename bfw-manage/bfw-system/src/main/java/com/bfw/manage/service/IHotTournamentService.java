package com.bfw.manage.service;

import com.bfw.manage.domain.CategoryExt;
import com.bfw.manage.domain.HotTournament;
import com.bfw.manage.domain.HotTournamentExt;
import com.bfw.manage.domain.TournamentExt;

import java.util.List;

/**
 * 热门赛事Service接口
 * 
 * @author barkley
 * @date 2019-08-15
 */
public interface IHotTournamentService 
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

    /**
     * 查询热门赛事列表
     *
     * @param hotTournament 热门赛事
     * @return 热门赛事集合
     */
    public List<HotTournamentExt> selectHotList(HotTournament hotTournament);



    /**
     * list
     * @param name
     * @return
     */
    public List<CategoryExt> selectCategoryList(String name);

    /**
     * @param categoryId
     * @return
     */
    public List<TournamentExt> selectTournamentList(Integer categoryId);

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
     * 批量删除热门赛事
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotTournamentByIds(String ids);

    /**
     * 删除热门赛事信息
     * 
     * @param hotId 热门赛事ID
     * @return 结果
     */
    public int deleteHotTournamentById(Long hotId);
}
