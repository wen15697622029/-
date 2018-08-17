package com.w.dao;


import com.w.model.Recruit;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface RecruitMapper {

    Recruit getRecruitByUserRe(int uid, int reid);

    int addRecruit(Recruit recruit);

    int getRecruitByRiidRstate(int riid, int rstate);

    List<Recruit> queryCurrentPageRecruitByRiidRstate(int riid, int rstate, int begin, int end);

    int updateRecruit(Recruit recruit);

    Recruit getRecruitByRid(int rid);

    Recruit getRecruitByUidRiid(int uid, int riid);
}
