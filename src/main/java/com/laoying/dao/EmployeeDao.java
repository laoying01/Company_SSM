package com.laoying.dao;

import com.laoying.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee getEmpByNameAndPass(Employee employee);
    boolean addEmp(Employee employee);
    List<Employee> getEmployees(int d_id);
}
