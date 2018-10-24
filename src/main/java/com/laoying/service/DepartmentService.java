package com.laoying.service;

import com.laoying.model.Department;

import java.util.List;

public interface DepartmentService {
    Department getDepart(int d_id);
    boolean addDepart(Department department);
    boolean updateDepart(Department department);
    boolean deleteDepart(Department department);
    Department getDepartment(String d_name);
    List<Department> getDepartments();
}
