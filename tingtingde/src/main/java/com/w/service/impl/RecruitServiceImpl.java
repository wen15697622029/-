package com.w.service.impl;

import com.w.dao.RecruitMapper;
import com.w.model.Recruit;
import com.w.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class RecruitServiceImpl implements RecruitService{
    @Resource
    private RecruitMapper recruitMapper;

    @Override
    public Recruit getRecruitByUserRe(int u_id, int re_id) {
        return recruitMapper.getRecruitByUserRe(u_id,re_id);
    }

    @Override
    public int addRecruit(Recruit recruit) {
        return recruitMapper.addRecruit(recruit);
    }

    @Override
    public int getRecruitByRiidRstate(int ri_id, int r_state) {
        return recruitMapper.getRecruitByRiidRstate(ri_id,r_state);
    }

    @Override
    public List<Recruit> queryCurrentPageRecruitByRiidRstate(int ri_id, int r_state, int begin, int end) {
        return recruitMapper.queryCurrentPageRecruitByRiidRstate(ri_id,r_state,begin,end);
    }

    @Override
    public int updateRecruit(Recruit recruit) {
        return recruitMapper.updateRecruit(recruit);
    }

    @Override
    public Recruit getRecruitByRid(int r_id) {
        return recruitMapper.getRecruitByRid(r_id);
    }

    @Override
    public Recruit getRecruitByUidRiid(int u_id, int ri_id) {
        return recruitMapper.getRecruitByUidRiid(u_id,ri_id);
    }
}
