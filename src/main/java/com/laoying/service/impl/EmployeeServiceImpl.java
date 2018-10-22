package com.laoying.service.impl;

import com.laoying.dao.EmployeeDao;
import com.laoying.model.Employee;
import com.laoying.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    public Employee getEmpByNameAndPass(String name, String pass) {
        return employeeDao.getEmpByNameAndPass(name,pass);
    }

    public boolean addEmp(Employee employee) {
        return employeeDao.addEmp(employee);
    }
}
