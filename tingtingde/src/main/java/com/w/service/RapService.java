package com.w.service;


import com.w.model.Rap;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface RapService {
    int addRap(Rap rap);

    int getCountMonthBySid(@Param("sid")int sid, @Param("radate")Date radate);

    List<Rap> queryCountMonthBySid(@Param("sid")int sid,@Param("radate")Date radate, @Param("begin") int begin,@Param("end") int end);

    int getCountDayByDidJid(@Param("did")int did, @Param("jid")int jid,@Param("radate")Date radate);

    List<Rap> queryCurrentPageStaffDayByDidJid(@Param("did")int did,@Param("jid") int jid,@Param("radate")Date radate,@Param("begin") int begin,@Param("end") int end);

    List<Rap> getRapLastMonthBySid(int sid);
}
