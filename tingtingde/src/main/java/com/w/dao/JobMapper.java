package com.w.dao;


import com.w.model.Job;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface JobMapper {

    List<Job> getJob();

    List<Job> getJobByDid(int did);

    int deleteJobByDid(int did);

    int deleteJobByJid(int jid);

    int addJob(int did, String jname,double jsalary);

    int updateJob(int jid, String jname,double jsalary);
    int getCountByJname(String jname);

    Job getJobByJid(int jid);
}
