package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Pay implements Serializable{
    private int pid;//薪资表id
    private Date pdate;//月份
    private Staff staff;//员工id
    private double pbase;//基本工资
    private double pperformance;//绩效奖金
    private double povertime;//加班费用
    private double prap;//奖惩费用
    private double pss;//社保
    private double ppay;//实际工资
    private int pstate;//状态
    private String pintro;//说明

    public Pay() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public double getPbase() {
        return pbase;
    }

    public void setPbase(double pbase) {
        this.pbase = pbase;
    }

    public double getPperformance() {
        return pperformance;
    }

    public void setPperformance(double pperformance) {
        this.pperformance = pperformance;
    }

    public double getPovertime() {
        return povertime;
    }

    public void setPovertime(double povertime) {
        this.povertime = povertime;
    }

    public double getPrap() {
        return prap;
    }

    public void setPrap(double prap) {
        this.prap = prap;
    }

    public double getPss() {
        return pss;
    }

    public void setPss(double pss) {
        this.pss = pss;
    }

    public double getPpay() {
        return ppay;
    }

    public void setPpay(double ppay) {
        this.ppay = ppay;
    }

    public int getPstate() {
        return pstate;
    }

    public void setPstate(int pstate) {
        this.pstate = pstate;
    }

    public String getPintro() {
        return pintro;
    }

    public void setPintro(String pintro) {
        this.pintro = pintro;
    }

    public Pay(Staff staff, double pbase, double pperformance, double povertime, double prap, double pss, double ppay, int pstate) {
        this.staff = staff;
        this.pbase = pbase;
        this.pperformance = pperformance;
        this.povertime = povertime;
        this.prap = prap;
        this.pss = pss;
        this.ppay = ppay;
        this.pstate = pstate;
    }

    @Override
    public String toString() {
        return "Pay{" + "pid=" + pid + ", pdate=" + pdate + ", staff=" + staff + ", pbase=" + pbase + ", pperformance=" + pperformance + ", povertime=" + povertime + ", prap=" + prap + ", pss=" + pss + ", ppay=" + ppay + ", pstate=" + pstate + ", pintro='" + pintro + '\'' + '}';
    }
}
