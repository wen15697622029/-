package com.w.dao;


import com.w.model.Department;

import java.util.List;

/**
 * Created by destiny on 2018/7/18/0018.
 */
public interface DepartmentMapper {

    List<Department> getDepartment();

    int deleteDepartment(int did);

    int addDepartment(String dname);

    int updateDepartment(int did,String dname);
    int getCountByDname(String dname);
}
