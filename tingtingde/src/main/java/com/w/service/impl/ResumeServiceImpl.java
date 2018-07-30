package com.w.service.impl;

import com.w.dao.ResumeMapper;
import com.w.model.Resume;
import com.w.model.User;
import com.w.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;

    @Override
    public int getResumeByUser(User user) {
        return resumeMapper.getResumeByUser(user);
    }

    @Override
    public List<Resume> queryCurrentResumeByUser(int uid, int begin, int end) {
        return resumeMapper.queryCurrentResumeByUser(uid,begin,end);
    }

    @Override
    public int addResume(Resume resume) {
        return resumeMapper.addResume(resume);
    }

    @Override
    public Resume getResumeByReid(int reid) {
        return resumeMapper.getResumeByReid(reid);
    }

    @Override
    public int updateResume(Resume resume) {
        return resumeMapper.updateResume(resume);
    }

    @Override
    public int deleteResume(Resume resume) {
        return resumeMapper.deleteResume(resume);
    }

    @Override
    public List<Resume> getResumesByUser(User user) {
        return resumeMapper.getResumesByUser(user);
    }
}
