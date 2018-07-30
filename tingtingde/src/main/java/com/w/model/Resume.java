package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Resume implements Serializable {
    private int reid;//简历表id
    private User user;//用户id；
    private String rename;//姓名
    private String resex;//性别
    private Date rebirthday;//出生日期
    private String rephone;//手机号
    private String reemall;//邮箱地址
    private int reidcardno;//身份证号
    private String readdress;//地址
    private int repost;//邮政编码
    private String recillege;//大学
    private String remajor;//专业
    private Date regraduate;//毕业时间
    private String reintro;//简介
    private String reeducation;//学历
    private String resumename;//简历名字

    public Resume() {
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getResex() {
        return resex;
    }

    public void setResex(String resex) {
        this.resex = resex;
    }

    public Date getRebirthday() {
        return rebirthday;
    }

    public void setRebirthday(Date rebirthday) {
        this.rebirthday = rebirthday;
    }

    public String getRephone() {
        return rephone;
    }

    public void setRephone(String rephone) {
        this.rephone = rephone;
    }

    public String getReemall() {
        return reemall;
    }

    public void setReemall(String reemall) {
        this.reemall = reemall;
    }

    public int getReidcardno() {
        return reidcardno;
    }

    public void setReidcardno(int reidcardno) {
        this.reidcardno = reidcardno;
    }

    public String getReaddress() {
        return readdress;
    }

    public void setReaddress(String readdress) {
        this.readdress = readdress;
    }

    public int getRepost() {
        return repost;
    }

    public void setRepost(int repost) {
        this.repost = repost;
    }

    public String getRecillege() {
        return recillege;
    }

    public void setRecillege(String recillege) {
        this.recillege = recillege;
    }

    public String getRemajor() {
        return remajor;
    }

    public void setRemajor(String remajor) {
        this.remajor = remajor;
    }

    public Date getRegraduate() {
        return regraduate;
    }

    public void setRegraduate(Date regraduate) {
        this.regraduate = regraduate;
    }

    public String getReintro() {
        return reintro;
    }

    public void setReintro(String reintro) {
        this.reintro = reintro;
    }

    public String getReeducation() {
        return reeducation;
    }

    public void setReeducation(String reeducation) {
        this.reeducation = reeducation;
    }

    public String getResumename() {
        return resumename;
    }

    public void setResumename(String resumename) {
        this.resumename = resumename;
    }

    @Override
    public String toString() {
        return "Resume{" + "reid=" + reid + ", user=" + user + ", rename='" + rename + '\'' + ", resex='" + resex + '\'' + ", rebirthday=" + rebirthday + ", rephone='" + rephone + '\'' + ", reemall='" + reemall + '\'' + ", reidcardno=" + reidcardno + ", readdress='" + readdress + '\'' + ", repost=" + repost + ", recillege='" + recillege + '\'' + ", remajor='" + remajor + '\'' + ", regraduate=" + regraduate + ", reintro='" + reintro + '\'' + ", reeducation='" + reeducation + '\'' + ", resumename='" + resumename + '\'' + '}';
    }
}
