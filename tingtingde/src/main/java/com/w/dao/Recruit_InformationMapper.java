package com.w.dao;


import com.w.model.Recruit_Information;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface Recruit_InformationMapper {

    int getRecruit_InformationByRiState(int i);

    List<Recruit_Information> queryCurrentPageRecruit_InformationByRiState(int state, int begin, int end);
}
