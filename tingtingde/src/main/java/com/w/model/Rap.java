package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Rap implements Serializable {
    private int raid;//奖惩表id
    private Date radate;//日期
    private double ramoney;//金额
    private Staff staff;//员工id
    private String raexplain;//说明

    public Rap() {
    }

    public Rap(double ramoney, Staff staff, String raexplain) {
        this.ramoney = ramoney;
        this.staff = staff;
        this.raexplain = raexplain;
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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public double getRamoney() {
        return ramoney;
    }

    public void setRamoney(double ramoney) {
        this.ramoney = ramoney;
    }

    public String getRaexplain() {
        return raexplain;
    }

    public void setRaexplain(String raexplain) {
        this.raexplain = raexplain;
    }

    @Override
    public String toString() {
        return "Rap{" + "raid=" + raid + ", radate=" + radate + ", ramoney=" + ramoney + ", staff=" + staff + ", raexplain='" + raexplain + '\'' + '}';
    }
}
