package com.laoying.controller;

import com.laoying.model.Employee;
import com.laoying.model.Training;
import com.laoying.service.DepartmentService;
import com.laoying.service.EmployeeService;
import com.laoying.service.TrainingService;
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
public class TrainingController {
    @Autowired
    private TrainingService trainingService;
    @Autowired
    private EmployeeService employeeService;

    /*添加员工培训记录*/
    @RequestMapping("/addTraining")
    public String addTraining(HttpServletRequest request)throws Exception{
        String[] arr=request.getParameterValues("change");//得到选中的员工
        String theme =request.getParameter("t_theme");
        String content =request.getParameter("t_content");
        String start_time =request.getParameter("t_start_time");
        String end_time = request.getParameter("t_end_time");
        String address = request.getParameter("t_address");
        String time1 = request.getParameter("t1");
        String time2 = request.getParameter("t2");
        start_time = start_time+" "+time1+":00";
        end_time = end_time+" "+time2+":00";
        Training training = new Training(theme,content, start_time,
                end_time,address);
        for (int i = 0; i <arr.length ; i++) {
            training.setEmp_id(Integer.parseInt(arr[i]));
            trainingService.addTraining(training);
        }
        return "addTraining";
    }

    /*添加部门培训记录*/
    @RequestMapping("/addTrainings")
    public String addTrainings(HttpServletRequest request)throws Exception{
        String[] arr=request.getParameterValues("change");//得到选中的部门
        String theme =request.getParameter("t_theme");
        String content =request.getParameter("t_content");
        String start_time =request.getParameter("t_start_time");
        String end_time = request.getParameter("t_end_time");
        String address = request.getParameter("t_address");
        String time1 = request.getParameter("t1");
        String time2 = request.getParameter("t2");
        start_time = start_time+" "+time1+":00";
        end_time = end_time+" "+time2+":00";
        Training training = new Training(theme,content, start_time,
                end_time,address);
        for (int i = 0; i <arr.length ; i++) {
            List<Employee> employees =employeeService.getEmployees(Integer.parseInt(arr[i]));
            for (Employee emp:employees){
                training.setEmp_id(emp.getEmp_id());
                trainingService.addTraining(training);
            }
        }
        return "addTrainings";
    }
    /*查看培训记录*/
    @RequestMapping("/getTrainings")
    public String getTrainings(HttpSession session)throws Exception{
        List<Training> trainings =trainingService.getTrainings();
        session.setAttribute("trainings",trainings);
        return "showTraining";
    }
    /*跳转培训页面*/
    @RequestMapping("/goUpdateTraining")
    public String goUpdateTraining(HttpServletRequest request,Model model)throws Exception{
        int id = Integer.parseInt(request.getParameter("tId"));
        Training training =trainingService.findTraining(id);
        model.addAttribute("training",training);
        return "updateTraining";
    }
    /*修改培训信息*/
    @RequestMapping("/updateTraining")
    public String updateTraining(HttpServletRequest request,HttpSession session)throws Exception{
        int id = Integer.parseInt(request.getParameter("t_id"));
        String theme =request.getParameter("t_theme");
        String content =request.getParameter("t_content");
        String start_time =request.getParameter("t_start_time");
        String end_time = request.getParameter("t_end_time");
        String address = request.getParameter("t_address");
        int emp_id= Integer.parseInt(request.getParameter("emp_id"));
        Date date = MyUtil.toDate(start_time);
        Training training = new Training(id,theme,content,start_time,
                end_time,emp_id,address);
        trainingService.updateTraining(training);
        List<Training> trainings =trainingService.getTrainings();
        session.setAttribute("trainings",trainings);
        return "showTraining";
    }
    /*删除培训信息*/
    @RequestMapping("/deleteTraining")
    public String deleteTraining(HttpServletRequest request,HttpSession session)throws Exception{
        int id = Integer.parseInt(request.getParameter("tId"));
        Training training =trainingService.findTraining(id);
        trainingService.deleteTraining(training);
        List<Training> trainings =trainingService.getTrainings();
        session.setAttribute("trainings",trainings);
        return "showTraining";
    }

    /*员工查看自己培训信息*/
    @RequestMapping("/showTraining")
    public String showTraining(HttpSession session)throws Exception{
        Employee employee = (Employee) session.getAttribute("employee");
        List<Training> trainings =trainingService.getTraining(employee.getEmp_id());
        session.setAttribute("emp_training",trainings);
        return "showEmpTraining";
    }
}
