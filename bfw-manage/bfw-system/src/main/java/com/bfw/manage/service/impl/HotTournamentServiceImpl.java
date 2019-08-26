package com.bfw.manage.service.impl;

import java.util.List;

import com.bfw.common.annotation.DataSource;
import com.bfw.common.enums.DataSourceType;
import com.bfw.manage.domain.CategoryExt;
import com.bfw.manage.domain.HotTournamentExt;
import com.bfw.manage.domain.TournamentExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bfw.manage.mapper.HotTournamentMapper;
import com.bfw.manage.domain.HotTournament;
import com.bfw.manage.service.IHotTournamentService;
import com.bfw.common.core.text.Convert;

/**
 * 热门赛事Service业务层处理
 * 
 * @author barkley
 * @date 2019-08-15
 */
@Service
public class HotTournamentServiceImpl implements IHotTournamentService 
{
    @Autowired
    private HotTournamentMapper hotTournamentMapper;

    /**
     * 查询热门赛事
     * 
     * @param hotId 热门赛事ID
     * @return 热门赛事
     */
    @Override
    public HotTournament selectHotTournamentById(Long hotId)
    {
        return hotTournamentMapper.selectHotTournamentById(hotId);
    }

    @Override
    public List<HotTournament> selectHotTournamentList(HotTournament hotTournament)
    {
        return hotTournamentMapper.selectHotTournamentList(hotTournament);
    }

    /**
     * 查询热门赛事列表
     * 
     * @param hotTournament 热门赛事
     * @return 热门赛事
     */
    @Override
    @DataSource(DataSourceType.DB2)
    public List<HotTournamentExt> selectHotList(HotTournament hotTournament)
    {
        return hotTournamentMapper.selectHotList(hotTournament);
    }

    @Override
    @DataSource(DataSourceType.DB2)
    public List<CategoryExt> selectCategoryList(String continent) {
        return hotTournamentMapper.selectCategoryList(continent);
    }

    @Override
    public List<TournamentExt> selectTournamentList(Integer categoryId) {
        return hotTournamentMapper.selectTournamentList(categoryId);
    }

    /**
     * 新增热门赛事
     * 
     * @param hotTournament 热门赛事
     * @return 结果
     */
    @Override
    public int insertHotTournament(HotTournament hotTournament)
    {
        return hotTournamentMapper.insertHotTournament(hotTournament);
    }

    /**
     * 修改热门赛事
     * 
     * @param hotTournament 热门赛事
     * @return 结果
     */
    @Override
    public int updateHotTournament(HotTournament hotTournament)
    {
        return hotTournamentMapper.updateHotTournament(hotTournament);
    }

    /**
     * 删除热门赛事对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHotTournamentByIds(String ids)
    {
        return hotTournamentMapper.deleteHotTournamentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除热门赛事信息
     * 
     * @param hotId 热门赛事ID
     * @return 结果
     */
    public int deleteHotTournamentById(Long hotId)
    {
        return hotTournamentMapper.deleteHotTournamentById(hotId);
    }
}
