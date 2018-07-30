package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Rap implements Serializable {
    private int raid;//奖惩表id
    private Date radate;//日期
    private int ramoney;//金额
    private Staff staff;//员工id
    private int raexplan;//说明

    public Rap() {
    }

    public int getRaid() {
        return raid;
    }

    public void setRaid(int raid) {
        this.raid = raid;
    }

    public Date getRadate() {
        return radate;
    }

    public void setRadate(Date radate) {
        this.radate = radate;
    }

    public int getRamoney() {
        return ramoney;
    }

    public void setRamoney(int ramoney) {
        this.ramoney = ramoney;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getRaexplan() {
        return raexplan;
    }

    public void setRaexplan(int raexplan) {
        this.raexplan = raexplan;
    }

    @Override
    public String toString() {
        return "Rap{" + "raid=" + raid + ", radate=" + radate + ", ramoney=" + ramoney + ", staff=" + staff + ", raexplan=" + raexplan + '}';
    }
}
