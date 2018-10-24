package com.laoying.service;

import com.laoying.model.Employee;

public interface EmployeeService {
    Employee getEmpByNameAndPass(Employee employee);
    boolean addEmp(Employee employee);
}
