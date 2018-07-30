package com.w.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/25.
 */
public class User implements Serializable {
    private int uid ;//游客id
    private String uname;//名字
    private String upass;//密码

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    @Override
    public String toString() {
        return "User{" + "uid=" + uid + ", uname='" + uname + '\'' + ", upass='" + upass + '\'' + '}';
    }
}
