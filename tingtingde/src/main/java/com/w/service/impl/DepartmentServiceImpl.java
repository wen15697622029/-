package com.w.service.impl;

import com.w.dao.DepartmentMapper;
import com.w.model.Department;
import com.w.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartment() {
        return departmentMapper.getDepartment();
    }

    @Override
    public int deleteDepartment(int did) {
        return departmentMapper.deleteDepartment( did );
    }

    @Override
    public int addDepartment(String dname) {
        return departmentMapper.addDepartment( dname );
    }

    @Override
    public int updateDepartment(int did, String dname) {
        return departmentMapper.updateDepartment( did, dname );
    }

    @Override
    public int getCountByDname(String dname) {
        return departmentMapper.getCountByDname( dname );
    }
}
