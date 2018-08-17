package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Attendance implements Serializable {
    private int aid;//考勤id
    private Staff staff;//员工id
    private Date adate;//日期
    private Date ontime;//上班时间
    private Date offtime;//下班时间
    private int astate;//状态

    public Attendance() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public Date getOntime() {
        return ontime;
    }

    public void setOntime(Date ontime) {
        this.ontime = ontime;
    }

    public int getAstate() {
        return astate;
    }

    public void setAstate(int astate) {
        this.astate = astate;
    }

    public Date getOfftime() {
        return offtime;
    }

    public void setOfftime(Date offtime) {
        this.offtime = offtime;
    }

    @Override
    public String toString() {
        return "Attendance{" + "aid=" + aid + ", staff=" + staff + ", adate=" + adate + ", ontime=" + ontime + ", offtime=" + offtime + ", astate=" + astate + '}';
    }
}
