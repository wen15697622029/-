package com.w.service.impl;

import com.w.dao.CultivateMapper;
import com.w.model.Cultivate;
import com.w.service.CultivateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class CultivateServiceImpl implements CultivateService{
    @Resource
    private CultivateMapper cultivateMapper;

    @Override
    public int getCultivateByCstate(int cstate) {
        return cultivateMapper.getCultivateByCstate( cstate );
    }

    @Override
    public List<Cultivate> queryCurrentPageCultivateByCstate(int cstate, int begin, int end) {
        return cultivateMapper.queryCurrentPageCultivateByCstate( cstate, begin, end );
    }

    @Override
    public int addCultivate(Cultivate cultivate) {
        return cultivateMapper.addCultivate( cultivate );
    }

    @Override
    public Cultivate getCultivateByCid(int cid) {
        return cultivateMapper.getCultivateByCid( cid );
    }

    @Override
    public int updateCultivate(Cultivate cultivate) {
        return cultivateMapper.updateCultivate( cultivate );
    }

    @Override
    public double getMinutesByCid(int cid) {
        return cultivateMapper.getMinutesByCid( cid );
    }

    @Override
    public List<Cultivate> getCultivateBySid(int sid, int begin, int end) {
        return cultivateMapper.getCultivateBySid( sid, begin, end );
    }

    @Override
    public int getCountBySid(int sid) {
        return cultivateMapper.getCountBySid( sid );
    }
}
