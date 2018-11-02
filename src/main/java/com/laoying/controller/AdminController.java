package com.laoying.controller;

import com.laoying.model.*;
import com.laoying.service.*;
import com.laoying.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private RecruitingService recruitingService;
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private DepartmentService departmentService;





    /*招聘信息页面*/
    @RequestMapping("/goRecruiting")
    public String goRecruiting(HttpSession session) throws Exception {
        List<Recruiting> recList = recruitingService.getRecruiting();
        List<Position> positionList = new ArrayList<Position>();
        Position position = null;
        for (int i = 0; i < recList.size(); i++) {
            position = positionService.getPosition(recList.get(i).getP_id());
            positionList.add(position);
        }
        session.setAttribute("positionList", positionList);
        session.setAttribute("recList", recList);
        return "recruiting";
    }

    /*管理员查看应聘申请*/
    @RequestMapping("/showInterview")
    public String showInterview(HttpSession session)throws Exception{
        List<Interview> interviews =interviewService.getInterviews();
        List<Position> positions = new ArrayList<Position>();
        for (int i = 0; i <interviews.size() ; i++) {
            Position p=positionService.getPosition(interviews.get(i).getP_id());
            positions.add(p);
        }
        session.setAttribute("i_position",positions);
        session.setAttribute("showInterview",interviews);
        return "showInterview";
    }
    /*查看简历*/
    @RequestMapping("/showResume")
    public String showResume(HttpServletRequest request,HttpSession session)throws Exception{
        int id = Integer.parseInt(request.getParameter("resId"));
        int i_id = Integer.parseInt(request.getParameter("interviewId"));
        Resume resume =resumeService.findResume(id);
        Interview interview = interviewService.getInterview(i_id);
        interview.setI_state(1);
        interviewService.updateInterview(interview);
        session.setAttribute("admin_resume",resume);
        session.setAttribute("interview",interview);
        return "showResume";
    }




    /*录用员工*/
    @RequestMapping("/admitVisitor")
    public String admitVisitor(HttpSession session,HttpServletRequest request)throws Exception{
        int id = Integer.parseInt(request.getParameter("admit_visitor_i_id"));
        Interview interview =interviewService.getInterview(id);
        interview.setI_state(4);
        interviewService.updateInterview(interview);
        Position position =positionService.getPosition(interview.getP_id());
        Department department = departmentService.getDepart(position.getD_id());
        Recruiting recruiting = recruitingService.getRec(position.getP_id());
        Resume resume =resumeService.findResume(interview.getRes_id());
        String str = resume.getRes_idCard().substring(0,6);
        String str1 ="在职";
        Employee employee = new Employee(str,str,department.getD_id(),position.getP_id(),
                resume.getRes_gender(),resume.getRes_age(),resume.getRes_birth(),
                MyUtil.toString(new Date()),recruiting.getRec_salary(),resume.getRes_name(),0,str1
                ,resume.getRes_phone(),resume.getRes_email());
        employeeService.addEmp(employee);
        session.setAttribute("interview",interview);
        return "admitVisitor";
    }

    @RequestMapping("/asdf")
    public String asdf()throws Exception{
        return "resume";
    }
    /*跳转添加招聘信息页面*/
    @RequestMapping("/goAddRecruiting")
    public String goAddRecruiting(HttpSession session)throws Exception{
        List<Position> positions =positionService.getPositions();
        session.setAttribute("positions",positions);
        return "addRecruiting";
    }

}
