package com.laoying.dao;

import com.laoying.model.Employee;

public interface EmployeeDao {
    Employee getEmpByNameAndPass(Employee employee);
    boolean addEmp(Employee employee);
}
