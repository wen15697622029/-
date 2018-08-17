package com.w.service.impl;

import com.w.dao.JobMapper;
import com.w.model.Job;
import com.w.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class JobServiceImpl implements JobService{
    @Resource
    private JobMapper jobMapper;

    @Override
    public List<Job> getJob() {
        return jobMapper.getJob();
    }

    @Override
    public List<Job> getJobByDid(int did) {
        return jobMapper.getJobByDid(did);
    }

    @Override
    public int deleteJobByDid(int did) {
        return jobMapper.deleteJobByDid( did );
    }

    @Override
    public int deleteJobByJid(int jid) {
        return jobMapper.deleteJobByJid( jid );
    }

    @Override
    public int addJob(int did, String jname, double jsalary) {
        return jobMapper.addJob( did, jname, jsalary );
    }

    @Override
    public int updateJob(int jid, String jname, double jsalary) {
        return jobMapper.updateJob( jid, jname, jsalary );
    }

    @Override
    public int getCountByJname(String jname) {
        return jobMapper.getCountByJname( jname );
    }

    @Override
    public Job getJobByJid(int jid) {
        return jobMapper.getJobByJid( jid );
    }
}
