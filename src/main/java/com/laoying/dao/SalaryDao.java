package com.laoying.dao;

import com.laoying.model.Salary;

import java.util.List;

public interface SalaryDao {
    List<Salary> getSalary();
    boolean addSalary(Salary salary);
    List<Salary> getSalaries(int emp_id);
}
