package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Pay implements Serializable{
    private int pid;//薪资表id
    private Date pdata;//月份
    private Staff staff;//员工id
    private int pbase;//基本工资
    private int pperformance;//绩效奖金
    private int povertime;//加班费用
    private int prap;//奖惩费用
    private int pss;//社保
    private int ppay;//实际工资
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

    public Date getPdata() {
        return pdata;
    }

    public void setPdata(Date pdata) {
        this.pdata = pdata;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getPbase() {
        return pbase;
    }

    public void setPbase(int pbase) {
        this.pbase = pbase;
    }

    public int getPperformance() {
        return pperformance;
    }

    public void setPperformance(int pperformance) {
        this.pperformance = pperformance;
    }

    public int getPovertime() {
        return povertime;
    }

    public void setPovertime(int povertime) {
        this.povertime = povertime;
    }

    public int getPrap() {
        return prap;
    }

    public void setPrap(int prap) {
        this.prap = prap;
    }

    public int getPss() {
        return pss;
    }

    public void setPss(int pss) {
        this.pss = pss;
    }

    public int getPpay() {
        return ppay;
    }

    public void setPpay(int ppay) {
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

    @Override
    public String toString() {
        return "Pay{" + "pid=" + pid + ", pdata=" + pdata + ", staff=" + staff + ", pbase=" + pbase + ", pperformance=" + pperformance + ", povertime=" + povertime + ", prap=" + prap + ", pss=" + pss + ", ppay=" + ppay + ", pstate=" + pstate + ", pintro='" + pintro + '\'' + '}';
    }
}
