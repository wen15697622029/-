package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Staff implements Serializable {
    private int sid;//员工表id
    private String susername;//用户名
    private String spadd;//密码
    private Department department;//部门id
    private Job job;//职位id；
    private int sstate;//入职状态
    private String sname;//姓名
    private String ssex;//性别
    private int sidcardno;//身份证号码
    private Date sbirrhday;//出生日期
    private String sphone;//手机号
    private String semall;//邮箱地址
    private String saddress;//地址
    private String spost;//邮政编码
    private String seducation;//学历
    private String scollege;//大学
    private String smajor;//专业
    private Date sgraduta;//毕业时间
    private String sintro;//简介
    private Date sentrdate;//入职时间

    public Staff() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }

    public String getSpadd() {
        return spadd;
    }

    public void setSpadd(String spadd) {
        this.spadd = spadd;
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

    public int getSstate() {
        return sstate;
    }

    public void setSstate(int sstate) {
        this.sstate = sstate;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSidcardno() {
        return sidcardno;
    }

    public void setSidcardno(int sidcardno) {
        this.sidcardno = sidcardno;
    }

    public Date getSbirrhday() {
        return sbirrhday;
    }

    public void setSbirrhday(Date sbirrhday) {
        this.sbirrhday = sbirrhday;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSemall() {
        return semall;
    }

    public void setSemall(String semall) {
        this.semall = semall;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getSpost() {
        return spost;
    }

    public void setSpost(String spost) {
        this.spost = spost;
    }

    public String getSeducation() {
        return seducation;
    }

    public void setSeducation(String seducation) {
        this.seducation = seducation;
    }

    public String getScollege() {
        return scollege;
    }

    public void setScollege(String scollege) {
        this.scollege = scollege;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public Date getSgraduta() {
        return sgraduta;
    }

    public void setSgraduta(Date sgraduta) {
        this.sgraduta = sgraduta;
    }

    public String getSintro() {
        return sintro;
    }

    public void setSintro(String sintro) {
        this.sintro = sintro;
    }

    public Date getSentrdate() {
        return sentrdate;
    }

    public void setSentrdate(Date sentrdate) {
        this.sentrdate = sentrdate;
    }

    @Override
    public String toString() {
        return "Staff{" + "sid=" + sid + ", susername='" + susername + '\'' + ", spadd='" + spadd + '\'' + ", department=" + department + ", job=" + job + ", sstate=" + sstate + ", sname='" + sname + '\'' + ", ssex='" + ssex + '\'' + ", sidcardno=" + sidcardno + ", sbirrhday=" + sbirrhday + ", sphone='" + sphone + '\'' + ", semall='" + semall + '\'' + ", saddress='" + saddress + '\'' + ", spost='" + spost + '\'' + ", seducation='" + seducation + '\'' + ", scollege='" + scollege + '\'' + ", smajor='" + smajor + '\'' + ", sgraduta=" + sgraduta + ", sintro='" + sintro + '\'' + ", sentrdate=" + sentrdate + '}';
    }
}
