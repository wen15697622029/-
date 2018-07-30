package com.w.service;


import com.w.model.Recruit_Information;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface Recruit_InformationService {
    int getRecruit_InformationByRiState(int i);

    List<Recruit_Information> queryCurrentPageRecruit_InformationByRiState(int state, int begin, int end);
}
