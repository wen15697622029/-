package com.w.service;


import com.w.model.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface AttendanceService {
    int getCountDayBySid(int sid);

    int addAttendance(Attendance attendance);
    int getCountMonthBySid(@Param("sid")int sid, @Param("adate")Date adate);

    List<Attendance> queryCountMonthBySid(@Param("sid")int s_id,@Param("adate")Date adate, @Param("begin")int begin,@Param("end") int end);

    double getOnMinutes(int sid);

    Attendance getAttendanceBySid(int sid);

    int off (int aid);

    double getOffMinutes(int sid);

    int updateAttendance(Attendance attendance);
    int getCountDayByDidJid(@Param("did")int did, @Param("jid")int jid,@Param("adate")Date adate);

    List<Attendance> queryCurrentPageStaffDayByDidJid(@Param("did")int did,@Param("jid") int jid,@Param("adate")Date adate,@Param("begin") int begin,@Param("end") int end);

    int getCountLastMonthBySid(int sid);

    List<Attendance> getAttendanceLastMonthBySid(int sid);

    double getOffMinutesByAid(int aid);
}
