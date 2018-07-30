package com.w.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/26.
 */
public class Recruit implements Serializable {
    private int rid;//招聘表id
    private Recruit_Information recruitInformation;//招聘信息
    private Resume resume;//简历
    private int rstate;//招聘状态

    public Recruit() {
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Recruit_Information getRecruitInformation() {
        return recruitInformation;
    }

    public void setRecruitInformation(Recruit_Information recruitInformation) {
        this.recruitInformation = recruitInformation;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public int getRstate() {
        return rstate;
    }

    public void setRstate(int rstate) {
        this.rstate = rstate;
    }

    @Override
    public String toString() {
        return "Recruit{" + "rid=" + rid + ", recruitInformation=" + recruitInformation + ", resume=" + resume + ", rstate=" + rstate + '}';
    }
}
