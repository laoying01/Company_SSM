package com.laoying.controller;

import com.laoying.model.Department;
import com.laoying.model.Employee;
import com.laoying.model.Position;
import com.laoying.service.DepartmentService;
import com.laoying.service.EmployeeService;
import com.laoying.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
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
                    return "employee";
                } else {
                    return "error";
                }
            }
        }
    }
    /*二级联动查看改职位下有哪些员工*/
    @RequestMapping("/selectEmp")
    public @ResponseBody List<Employee> selectEmp(HttpServletRequest request)throws Exception{
        int s1 = Integer.parseInt(request.getParameter("posId"));
        return employeeService.findEmployees(s1);
    }

    /*查看所有的员工*/
    @RequestMapping("/getAllEmp")
    public String getAllEmp(HttpSession session)throws Exception{
        List<Employee> employees =employeeService.getAllEmp();
        session.setAttribute("allEmp",employees);
        return "showEmployee";
    }

    /*换岗*/
    @RequestMapping("/relieveGuard")
    public  String relieveGuard(HttpServletRequest request,HttpSession session)throws Exception{
        Employee employee= (Employee) session.getAttribute("employeeId");
        int d_id = Integer.parseInt(request.getParameter("changeP"));
        int p_id = Integer.parseInt(request.getParameter("changeE"));
        employee.setD_id(d_id);
        employee.setP_id(p_id);
        employeeService.updateEmp(employee);
        List<Employee> employees =employeeService.getAllEmp();
        session.setAttribute("allEmp",employees);
        return "showEmployee";
    }
    /*去换岗*/
    @RequestMapping("/toRelieveGuard")
    public String toRelieveGuard(HttpServletRequest request,HttpSession session)throws Exception{
        int id = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee =employeeService.getEmp(id);
        List<Department> departments =departmentService.getDepartments();
        session.setAttribute("employeeId",employee);
        session.setAttribute("allDep",departments);
        return "relieveGuard";
    }

    /*离职*/
    @RequestMapping("/dimission")
    public String dimission(HttpSession session,HttpServletRequest request)throws Exception{
       Employee employee = (Employee) session.getAttribute("employee");
       String str =request.getParameter("dimission");
       employeeService.updateEmp(employee);
       return "employee";
    }
    /*查看试用期员工*/
    @RequestMapping("/getEmpByState")
    public String getEmpByState(HttpSession session)throws Exception{
        List<Employee> employees =employeeService.getEmpByState();
        session.setAttribute("empByState",employees);
        return "probationPeriod";
    }
    /*转正*/
    @RequestMapping("/changeOfficial")
    public String changeOfficial(HttpServletRequest request)throws Exception{
        int id = Integer.parseInt(request.getParameter("e_id"));
        Employee employee =employeeService.getEmp(id);
        Date newDate = MyUtil.addDate1(MyUtil.toDate(employee.getEmp_entry_time()));
        if (newDate.after(new Date())){
            request.setAttribute("msg","不能转正");
            return "probationPeriod";
        }else {
            employee.setEmp_state(1);
            employeeService.updateEmp(employee);
            return "employee";
        }
    }
}
