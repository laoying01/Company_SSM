package com.laoying.controller;

import com.laoying.model.Employee;
import com.laoying.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    /*员工登录*/
    @RequestMapping("/empLogin")
    public String empLogin(HttpServletRequest request, HttpSession session) throws Exception {
        String name = request.getParameter("emp_name");
        String pass = request.getParameter("emp_pass");
        Employee employee = employeeService.getEmpByNameAndPass(new Employee(name,pass));
        if (employee == null) {
            return "error";
        } else {
            if ("admin".equals(employee.getEmp_account_number()) && "admin".equals(employee.getEmp_pass())) {
                return "admin";
            } else {
                if (name.equals(employee.getEmp_account_number()) && pass.equals(employee.getEmp_pass())) {
                    session.setAttribute("employee", employee);
                    return "";
                } else {
                    return "error";
                }
            }
        }
    }
}
