package com.w.model;



import com.w.service.Recruit_InformationService;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Interview implements Serializable {
    private int iid;//面试表id
    private User user;//用户id
    private Recruit_Information recruit_information;//招聘信息id
    private int istate;//状态
    private Date idate;//面试时间
    private String iaddress;//面试地址
    private String iintro;//面试说明
    private Staff staff;//面试人

    public Interview() {
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public int getIstate() {
        return istate;
    }

    public void setIstate(int istate) {
        this.istate = istate;
    }

    public Date getIdate() {
        return idate;
    }

    public void setIdate(Date idate) {
        this.idate = idate;
    }

    public String getIaddress() {
        return iaddress;
    }

    public void setIaddress(String iaddress) {
        this.iaddress = iaddress;
    }

    public String getIintro() {
        return iintro;
    }

    public void setIintro(String iintro) {
        this.iintro = iintro;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Recruit_Information getRecruit_information() {
        return recruit_information;
    }

    public void setRecruit_information(Recruit_Information recruit_information) {
        this.recruit_information = recruit_information;
    }

    @Override
    public String toString() {
        return "Interview{" + "iid=" + iid + ", user=" + user + ", recruit_information=" + recruit_information + ", istate=" + istate + ", idate=" + idate + ", iaddress='" + iaddress + '\'' + ", iintro='" + iintro + '\'' + ", staff=" + staff + '}';
    }
}
