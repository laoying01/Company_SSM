package com.laoying.controller;

import com.laoying.model.Department;
import com.laoying.service.DepartmentService;
import com.laoying.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    /*跳转添加部门*/
    @RequestMapping("/goAddDepartment")
    public String goAddDepartment()throws Exception{
        return "addDepartment";
    }
    /*添加部门*/
    @RequestMapping("/addDepartment")
    public String addDepartment(Department department, Model model)throws Exception{
        String date = MyUtil.toString(new Date());
        department.setD_create_time(date);
        boolean flag =departmentService.addDepart(department);
        if (flag){
            model.addAttribute("msg","true");
        }else {
            model.addAttribute("msg","false");
        }
        return "addDepartment";
    }

    /*查到要修改的部门，去修改*/
    @RequestMapping("/toUpdateDepartment")
    public String toUpdateDepartment(HttpServletRequest request)throws Exception{
        int id = Integer.parseInt(request.getParameter("d_id"));
        Department department=departmentService.getDepart(id);
        request.setAttribute("depart",department);
        return "updateDepartment";
    }
    /*修改*/
    @RequestMapping("/updateDepartment")
    public String updateDepartment(HttpServletRequest request,HttpSession session)throws Exception{
        String name =request.getParameter("d_depart");
        Department d =departmentService.getDepart(Integer.parseInt(request.getParameter("d_id")));
        d.setD_department(name);
        departmentService.updateDepart(d);
        List<Department> departments=departmentService.getDepartments();
        session.setAttribute("departmentList",departments);
        return "updateDepartment";
    }
    /*查询所有部门*/
    @RequestMapping("/getDepartment")
    public String getDepartment(HttpSession session)throws Exception{
        List<Department> departments=departmentService.getDepartments();
        session.setAttribute("departmentList",departments);
        return "updateDepartment";
    }

    /*删除部门*/
    @RequestMapping("/deleteDepart")
    public String deleteDepart(HttpServletRequest request,HttpSession session)throws Exception{
        int id = Integer.parseInt(request.getParameter("d_id"));
        Department department = new Department();
        department.setD_id(id);
        boolean flag =departmentService.deleteDepart(department);
        if (flag){
            request.setAttribute("msg","删除成功");
        }else {
            request.setAttribute("msg","删除失败");
        }
        List<Department> departments=departmentService.getDepartments();
        session.setAttribute("departmentList",departments);
        return "updateDepartment";
    }

    /*跳转添加部门培训*/
    @RequestMapping("/goAddTrainings")
    public String goAddTrainings(Model model)throws Exception{
        List<Department> departments =departmentService.getDepartments();
        model.addAttribute("t_d",departments);
        return "addTrainings";
    }
}
