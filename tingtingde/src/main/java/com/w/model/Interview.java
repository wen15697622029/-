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
    private Recruit_InformationService recruit_informationService;//招聘信息id
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

    public Recruit_InformationService getRecruit_informationService() {
        return recruit_informationService;
    }

    public void setRecruit_informationService(Recruit_InformationService recruit_informationService) {
        this.recruit_informationService = recruit_informationService;
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

    @Override
    public String toString() {
        return "Interview{" + "iid=" + iid + ", user=" + user + ", recruit_informationService=" + recruit_informationService + ", istate=" + istate + ", idate=" + idate + ", iaddress='" + iaddress + '\'' + ", iintro='" + iintro + '\'' + ", staff=" + staff + '}';
    }
}
