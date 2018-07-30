package com.w.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Cultivate implements Serializable {
    private int cid;//培训id
    private String ctheme;//主题
    private String ccontent;//内容
    private Date cbegintime;//开始时间
    private Date endtime;//结束时间
    private String caddress;//地址
    private int cstate;//状态
    private Date cissuetime;//发布时间

    public Cultivate() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCtheme() {
        return ctheme;
    }

    public void setCtheme(String ctheme) {
        this.ctheme = ctheme;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public Date getCbegintime() {
        return cbegintime;
    }

    public void setCbegintime(Date cbegintime) {
        this.cbegintime = cbegintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public int getCstate() {
        return cstate;
    }

    public void setCstate(int cstate) {
        this.cstate = cstate;
    }

    public Date getCissuetime() {
        return cissuetime;
    }

    public void setCissuetime(Date cissuetime) {
        this.cissuetime = cissuetime;
    }

    @Override
    public String toString() {
        return "Cultivate{" + "cid=" + cid + ", ctheme='" + ctheme + '\'' + ", ccontent='" + ccontent + '\'' + ", cbegintime=" + cbegintime + ", endtime=" + endtime + ", caddress='" + caddress + '\'' + ", cstate=" + cstate + ", cissuetime=" + cissuetime + '}';
    }
}
