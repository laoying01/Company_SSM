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
import java.util.ArrayList;
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
       employee.setEmp_dimission_cause(str);
       employee.setEmp_state(2);
       employeeService.updateEmp(employee);
       return "addDimission";
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
            return "probationPeriod";
        }
    }

    /*跳转添加培训页面*/
    @RequestMapping("/goAddTraining")
    public String goAddTraining(HttpSession session)throws Exception{
        List<Employee> employees=employeeService.getAllEmp();
        List<Employee> list = new ArrayList<Employee>();
        for (int i = 0; i <employees.size() ; i++) {
            if (employees.get(i).getEmp_state()!=2){
                list.add(employees.get(i));
            }
        }
        session.setAttribute("t_e",list);
        return "addTraining";
    }
    /*修改员工自己信息*/
    @RequestMapping("/updateEmployee")
    public String updateEmployee(HttpServletRequest request,HttpSession session)throws Exception{
        String emp_phone = request.getParameter("emp_phone");
        String emp_pass = request.getParameter("emp_pass");
        String emp_email = request.getParameter("emp_email");
        Employee employee = (Employee) session.getAttribute("employee");
        employee.setEmp_pass(emp_pass);
        employee.setEmp_phone(emp_phone);
        employee.setEmp_email(emp_email);
        employeeService.updateEmp(employee);
        return "updateEmployee";
    }
    /*跳转修改自己信息页面*/
    @RequestMapping("/goUpdateEmployee")
    public String goUpdateEmployee()throws Exception{
        return "updateEmployee";
    }
    /*查看自己信息*/
    @RequestMapping("/showEmployeeMe")
    public String showEmployeeMe(HttpSession session)throws Exception{
        Employee employee = (Employee) session.getAttribute("employee");
        session.setAttribute("employee",employee);
        return "showEmployeeByme";
    }
    /*查看其他员工信息*/
    @RequestMapping("/showOtherEmp")
    public String showOtherEmp(HttpSession session)throws Exception{
        List<Employee> employees =employeeService.findEmp();
        session.setAttribute("o_emp",employees);
        return "showotherEmp";
    }
}
