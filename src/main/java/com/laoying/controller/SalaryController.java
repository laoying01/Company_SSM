package com.laoying.controller;

import com.laoying.model.Employee;
import com.laoying.model.Salary;
import com.laoying.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.swing.text.TabableView;
import java.util.List;

@Controller
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    /*查询薪资表*/
    @RequestMapping("/getSalary")
    public String getSalary(HttpSession session)throws Exception{
        List<Salary> salaries =salaryService.getSalary();
        session.setAttribute("salaries",salaries);
        return "showSalary";
    }

    /*结算薪资*/
    @RequestMapping("/addSalary")
    public String addSalary(Salary salary,HttpSession session)throws Exception{
        salaryService.addSalary(salary);
        List<Salary> salaries =salaryService.getSalary();
        session.setAttribute("salaries",salaries);
        return "showSalary";
    }
    /*查看员工自己的薪资*/
    @RequestMapping("/showSalary")
    public String showSalary(HttpSession session)throws Exception{
        Employee employee = (Employee) session.getAttribute("employee");
        List<Salary> salaries =salaryService.getSalaries(employee.getEmp_id());
        session.setAttribute("emp_salary",salaries);
        return "showEmpSalary";
    }
}
