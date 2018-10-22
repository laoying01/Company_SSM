package com.laoying.service;

import com.laoying.model.Employee;

public interface EmployeeService {
    Employee getEmpByNameAndPass(String name, String pass);
    boolean addEmp(Employee employee);
}
