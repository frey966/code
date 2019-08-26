package com.bfw.manage.service.impl;

import java.util.List;
import com.bfw.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bfw.manage.mapper.STournamentMapper;
import com.bfw.manage.domain.STournament;
import com.bfw.manage.service.ISTournamentService;
import com.bfw.common.core.text.Convert;

/**
 * 联赛信息Service业务层处理
 * 
 * @author barkley
 * @date 2019-08-15
 */
@Service
public class STournamentServiceImpl implements ISTournamentService 
{
    @Autowired
    private STournamentMapper sTournamentMapper;

    /**
     * 查询联赛信息
     * 
     * @param id 联赛信息ID
     * @return 联赛信息
     */
    @Override
    public STournament selectSTournamentById(Long id)
    {
        return sTournamentMapper.selectSTournamentById(id);
    }

    /**
     * 查询联赛信息列表
     * 
     * @param sTournament 联赛信息
     * @return 联赛信息
     */
    @Override
    public List<STournament> selectSTournamentList(STournament sTournament)
    {
        return sTournamentMapper.selectSTournamentList(sTournament);
    }

    /**
     * 新增联赛信息
     * 
     * @param sTournament 联赛信息
     * @return 结果
     */
    @Override
    public int insertSTournament(STournament sTournament)
    {
        return sTournamentMapper.insertSTournament(sTournament);
    }

    /**
     * 修改联赛信息
     * 
     * @param sTournament 联赛信息
     * @return 结果
     */
    @Override
    public int updateSTournament(STournament sTournament)
    {
        return sTournamentMapper.updateSTournament(sTournament);
    }

    /**
     * 删除联赛信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSTournamentByIds(String ids)
    {
        return sTournamentMapper.deleteSTournamentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除联赛信息信息
     * 
     * @param id 联赛信息ID
     * @return 结果
     */
    public int deleteSTournamentById(Long id)
    {
        return sTournamentMapper.deleteSTournamentById(id);
    }
}
