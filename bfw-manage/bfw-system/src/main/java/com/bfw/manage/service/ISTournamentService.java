package com.bfw.manage.service;

import com.bfw.manage.domain.STournament;
import java.util.List;

/**
 * 联赛信息Service接口
 * 
 * @author barkley
 * @date 2019-08-15
 */
public interface ISTournamentService 
{
    /**
     * 查询联赛信息
     * 
     * @param id 联赛信息ID
     * @return 联赛信息
     */
    public STournament selectSTournamentById(Long id);

    /**
     * 查询联赛信息列表
     * 
     * @param sTournament 联赛信息
     * @return 联赛信息集合
     */
    public List<STournament> selectSTournamentList(STournament sTournament);

    /**
     * 新增联赛信息
     * 
     * @param sTournament 联赛信息
     * @return 结果
     */
    public int insertSTournament(STournament sTournament);

    /**
     * 修改联赛信息
     * 
     * @param sTournament 联赛信息
     * @return 结果
     */
    public int updateSTournament(STournament sTournament);

    /**
     * 批量删除联赛信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSTournamentByIds(String ids);

    /**
     * 删除联赛信息信息
     * 
     * @param id 联赛信息ID
     * @return 结果
     */
    public int deleteSTournamentById(Long id);
}
