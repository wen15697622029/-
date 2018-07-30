package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Department implements Serializable {
    private int did;//b部门id
    private String dname;//部门名字
    private Date ddate;//创建时间
    public Department() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    @Override
    public String toString() {
        return "Department{" + "did=" + did + ", dname='" + dname + '\'' + ", ddate=" + ddate + '}';
    }
}
