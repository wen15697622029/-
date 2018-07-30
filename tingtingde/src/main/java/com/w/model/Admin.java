package com.w.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Admin implements Serializable {
    private int adid;//管理id
    private String adname;//名字
    private String adpass;//密码
    private Staff staff;//员工id

    public Admin() {
    }

    public int getAdid() {
        return adid;
    }

    public void setAdid(int adid) {
        this.adid = adid;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getAdpass() {
        return adpass;
    }

    public void setAdpass(String adpass) {
        this.adpass = adpass;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Admin{" + "adid=" + adid + ", adname='" + adname + '\'' + ", adpass='" + adpass + '\'' + ", staff=" + staff + '}';
    }
}
