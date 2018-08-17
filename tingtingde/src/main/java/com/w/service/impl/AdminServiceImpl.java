package com.w.service.impl;

import com.w.dao.AdminMapper;
import com.w.model.Admin;
import com.w.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminByNamePass(Admin admin) {
        return adminMapper.getAdminByNamePass(admin);
    }
}
