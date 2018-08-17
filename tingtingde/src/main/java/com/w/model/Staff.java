package com.w.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Staff implements Serializable {
    private int sid;//员工表id
    private String susername;//用户名
    private String spass;//密码
    private Department department;//部门id
    private Job job;//职位id；
    private int sstate;//入职状态
    private String sname;//姓名
    private String ssex;//性别
    private String sidcardno;//身份证号码
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date sbirthday;//出生日期
    private String sphone;//手机号
    private String semail;//邮箱地址
    private String saddress;//地址
    private String spost;//邮政编码
    private String seducation;//学历
    private String scollege;//大学
    private String smajor;//专业
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date sgraduate;//毕业时间
    private String sintro;//简介
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date sentrydate;//入职时间

    public Staff() {
    }

    public Staff(int sid) {
        this.sid = sid;
    }

    public Staff(String susername, String spass, Department department, Job job, int sstate, String sname, String ssex, String sidcardno, Date sbirthday, String sphone, String semail, String saddress, String spost, String seducation, String scollege, String smajor, Date sgraduate, String sintro) {
        this.susername = susername;
        this.spass = spass;
        this.department = department;
        this.job = job;
        this.sstate = sstate;
        this.sname = sname;
        this.ssex = ssex;
        this.sidcardno = sidcardno;
        this.sbirthday = sbirthday;
        this.sphone = sphone;
        this.semail = semail;
        this.saddress = saddress;
        this.spost = spost;
        this.seducation = seducation;
        this.scollege = scollege;
        this.smajor = smajor;
        this.sgraduate = sgraduate;
        this.sintro = sintro;
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

    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass;
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

    public String getSidcardno() {
        return sidcardno;
    }

    public void setSidcardno(String sidcardno) {
        this.sidcardno = sidcardno;
    }

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
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

    public Date getSgraduate() {
        return sgraduate;
    }

    public void setSgraduate(Date sgraduate) {
        this.sgraduate = sgraduate;
    }

    public String getSintro() {
        return sintro;
    }

    public void setSintro(String sintro) {
        this.sintro = sintro;
    }

    public Date getSentrydate() {
        return sentrydate;
    }

    public void setSentrydate(Date sentrydate) {
        this.sentrydate = sentrydate;
    }

    @Override
    public String toString() {
        return "Staff{" + "sid=" + sid + ", susername='" + susername + '\'' + ", spass='" + spass + '\'' + ", department=" + department + ", job=" + job + ", sstate=" + sstate + ", sname='" + sname + '\'' + ", ssex='" + ssex + '\'' + ", sidcardno='" + sidcardno + '\'' + ", sbirthday=" + sbirthday + ", sphone='" + sphone + '\'' + ", semail='" + semail + '\'' + ", saddress='" + saddress + '\'' + ", spost='" + spost + '\'' + ", seducation='" + seducation + '\'' + ", scollege='" + scollege + '\'' + ", smajor='" + smajor + '\'' + ", sgraduate=" + sgraduate + ", sintro='" + sintro + '\'' + ", sentrydate=" + sentrydate + '}';
    }
}
