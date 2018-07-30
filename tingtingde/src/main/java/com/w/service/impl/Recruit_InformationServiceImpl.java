package com.w.service.impl;

import com.w.dao.Recruit_InformationMapper;
import com.w.model.Recruit_Information;
import com.w.service.Recruit_InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class Recruit_InformationServiceImpl implements Recruit_InformationService{
    @Resource
    private Recruit_InformationMapper recruit_informationMapper;

    @Override
    public int getRecruit_InformationByRiState(int i) {
        return recruit_informationMapper.getRecruit_InformationByRiState(i);
    }

    @Override
    public List<Recruit_Information> queryCurrentPageRecruit_InformationByRiState(int state, int begin, int end) {
        return recruit_informationMapper.queryCurrentPageRecruit_InformationByRiState(state,begin,end);
    }
}
