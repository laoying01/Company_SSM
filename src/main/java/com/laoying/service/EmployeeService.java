package com.laoying.service;

import com.laoying.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmpByNameAndPass(Employee employee);
    boolean addEmp(Employee employee);
    List<Employee> getEmployees(int d_id);
}
