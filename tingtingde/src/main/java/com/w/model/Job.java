package com.w.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Job implements Serializable {
    private int jid;//职位 id
    private String jname;//职位名字
    private Department department;//部门id
    private String jsalary;//基本工资

    public Job() {
    }



    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getJsalary() {
        return jsalary;
    }

    public void setJsalary(String jsalary) {
        this.jsalary = jsalary;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    @Override
    public String toString() {
        return "Job{" + "jid=" + jid + ", jname='" + jname + '\'' + ", department=" + department + ", jsalary='" + jsalary + '\'' + '}';
    }
}
