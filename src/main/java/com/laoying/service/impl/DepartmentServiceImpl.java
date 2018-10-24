package com.laoying.service.impl;

import com.laoying.dao.DepartmentDao;
import com.laoying.dao.EmployeeDao;
import com.laoying.model.Department;
import com.laoying.model.Employee;
import com.laoying.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.FlatteningPathIterator;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;
    public Department getDepart(int d_id) {
        return departmentDao.getDepart(d_id);
    }

    public boolean addDepart(Department department) {
        if (getDepartment(department.getD_department())!=null){
            return false;
        }else {
            departmentDao.addDepart(department);
            return true;
        }

    }

    public boolean updateDepart(Department department) {
      return departmentDao.updateDepart(department);
    }

    public boolean deleteDepart(Department department) {
        List<Employee> employees =employeeDao.getEmployees(department.getD_id());
        if (employees.size()!=0){
            return false;
        }else {
            departmentDao.deleteDepart(department);
            return true;
        }
    }

    public Department getDepartment(String d_name) {
        Department department =departmentDao.getDepartment(d_name);
        if (department!=null){
            return department;
        }
        return null;
    }

    public List<Department> getDepartments() {
            return departmentDao.getDepartments();
    }
}
