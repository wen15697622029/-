package com.w.service;


import com.w.model.Department;

import java.util.List;

/**
 * Created by destiny on 2018/7/25/0025.
 */
public interface DepartmentService {

    List<Department> getDepartment();

    int deleteDepartment(int did);

    int addDepartment(String dname);

    int updateDepartment(int did,String dname);
    int getCountByDname(String dname);
}
