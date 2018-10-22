package com.laoying.dao;

import com.laoying.model.Employee;

public interface EmployeeDao {
    Employee getEmpByNameAndPass(String name,String pass);
    boolean addEmp(Employee employee);
}
