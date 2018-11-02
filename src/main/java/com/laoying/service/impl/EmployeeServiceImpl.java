package com.laoying.service.impl;

import com.laoying.dao.EmployeeDao;
import com.laoying.model.Employee;
import com.laoying.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    public Employee getEmpByNameAndPass(Employee employee) {
        return employeeDao.getEmpByNameAndPass(employee);
    }

    public boolean addEmp(Employee employee) {
        return employeeDao.addEmp(employee);
    }

    public List<Employee> getEmployees(int d_id) {
        return employeeDao.getEmployees(d_id);
    }

    public List<Employee> findEmployees(int p_id) {
        return employeeDao.findEmployees(p_id);
    }

    public List<Employee> getAllEmp() {
        return employeeDao.getAllEmp();
    }

    public boolean updateEmp(Employee employee) {
        return employeeDao.updateEmp(employee);
    }

    public Employee getEmp(int emp_id) {
        return employeeDao.getEmp(emp_id);
    }

    public List<Employee> getEmpByState() {
        return employeeDao.getEmpByState();
    }

    public List<Employee> findEmp() {
        return employeeDao.findEmp();
    }
}
