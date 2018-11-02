package com.laoying.service;

import com.laoying.model.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> getSalary();
    boolean addSalary(Salary salary);
    List<Salary> getSalaries(int emp_id);
}
