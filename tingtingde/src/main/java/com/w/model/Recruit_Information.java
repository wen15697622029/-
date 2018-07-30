package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Recruit_Information implements Serializable {
    private int riid;//招聘信息表id
    private Department department;//部门id
    private Job job;//职位人数
    private int rinum;//招聘人数
    private String riintro;//描述
    private int ristate;//状态
    private Date riday;//时间

    public Recruit_Information() {
    }

    public int getRiid() {
        return riid;
    }

    public void setRiid(int riid) {
        this.riid = riid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getRinum() {
        return rinum;
    }

    public void setRinum(int rinum) {
        this.rinum = rinum;
    }

    public String getRiintro() {
        return riintro;
    }

    public void setRiintro(String riintro) {
        this.riintro = riintro;
    }

    public int getRistate() {
        return ristate;
    }

    public void setRistate(int ristate) {
        this.ristate = ristate;
    }

    public Date getRiday() {
        return riday;
    }

    public void setRiday(Date riday) {
        this.riday = riday;
    }

    @Override
    public String toString() {
        return "Recruit_Information{" + "riid=" + riid + ", department=" + department + ", job=" + job + ", rinum=" + rinum + ", riintro='" + riintro + '\'' + ", ristate=" + ristate + ", riday=" + riday + '}';
    }
}

