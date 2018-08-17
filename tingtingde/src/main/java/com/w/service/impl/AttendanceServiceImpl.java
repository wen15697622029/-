package com.w.service.impl;

import com.w.dao.AttendanceMapper;
import com.w.model.Attendance;
import com.w.service.AttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Resource
    private AttendanceMapper attendanceMapper;


    @Override
    public int getCountDayBySid(int sid) {
        return attendanceMapper.getCountDayBySid( sid );
    }

    @Override
    public int addAttendance(Attendance attendance) {
        return attendanceMapper.addAttendance( attendance );
    }

    @Override
    public int getCountMonthBySid(int sid, Date adate) {
        return attendanceMapper.getCountMonthBySid( sid, adate );
    }

    @Override
    public List<Attendance> queryCountMonthBySid(int sid, Date adate, int begin, int end) {
        return attendanceMapper.queryCountMonthBySid( sid, adate, begin, end );
    }

    @Override
    public double getOnMinutes(int sid) {
        return attendanceMapper.getOnMinutes( sid );
    }

    @Override
    public Attendance getAttendanceBySid(int sid) {
        return attendanceMapper.getAttendanceBySid( sid );
    }

    @Override
    public int off(int aid) {
        return attendanceMapper.off( aid );
    }

    @Override
    public double getOffMinutes(int sid) {
        return attendanceMapper.getOffMinutes( sid );
    }

    @Override
    public int updateAttendance(Attendance attendance) {
        return attendanceMapper.updateAttendance( attendance );
    }

    @Override
    public int getCountDayByDidJid(int did, int jid, Date adate) {
        return attendanceMapper.getCountDayByDidJid( did, jid, adate );
    }

    @Override
    public List<Attendance> queryCurrentPageStaffDayByDidJid(int did, int jid, Date adate, int begin, int end) {
        return attendanceMapper.queryCurrentPageStaffDayByDidJid( did, jid, adate, begin, end );
    }

    @Override
    public int getCountLastMonthBySid(int sid) {
        return attendanceMapper.getCountLastMonthBySid( sid );
    }

    @Override
    public List<Attendance> getAttendanceLastMonthBySid(int sid) {
        return attendanceMapper.getAttendanceLastMonthBySid( sid );
    }

    @Override
    public double getOffMinutesByAid(int aid) {
        return attendanceMapper.getOffMinutesByAid( aid);
    }
}
