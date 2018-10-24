package com.laoying.controller;

import com.laoying.dao.PositionDao;
import com.laoying.model.*;
import com.laoying.service.*;
import com.laoying.util.MyUtil;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private RecruitingService recruitingService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private InterviewService interviewService;
    @Autowired
    private DepartmentService departmentService;
    /*跳转登录页面*/
    @RequestMapping("/goLogin")
    public String goLogin() throws Exception {
        return "login";
    }

    /*跳转注册页面*/
    @RequestMapping("/goRegister")
    public String goRegister() throws Exception {
        return "register";
    }

    /*跳转游客页面*/
    @RequestMapping("/goVisitor")
    public String goVisitor() throws Exception {
        return "visitor";
    }
    /*跳转员工登录页面*/
    @RequestMapping("/goEmpLogin")
    public String goEmpLogin() throws Exception {
        return "empLogin";
    }

    /*没有简历跳转填简历页面*/
    @RequestMapping("/goResume")
    public String goResume(HttpSession session, HttpServletRequest request) throws Exception {
        int rec_id = Integer.parseInt(request.getParameter("rec_id"));
        Recruiting recruiting = recruitingService.findRecruiting(rec_id);
        session.setAttribute("recruiting", recruiting);
        User user = (User) session.getAttribute("user");
        Resume resume = resumeService.getResume(user.getU_id());
        if (resume == null) {
            return "resume";

        } else {
            session.setAttribute("resume", resume);
            return addInterview(session);
        }
    }

    /*登录*/
    @RequestMapping("/login")
    public String login(User user, HttpSession session) throws Exception {
        User user1 = userService.getUser(user);
        if (user1 != null) {
            session.setAttribute("user", user1);
            /*return "../../index";*/
            return "visitor";
        } else {
            return "error";
        }
    }

    /*注册验证用户名*/
    @RequestMapping("/verifyRegister")
    public String verifyRegister(HttpServletRequest request, Model model) throws Exception {
        String name = request.getParameter("u_name");
        User user = userService.getUser(new User(name));
        if (user != null) {
            model.addAttribute("msg", "用户名已存在");
            return "register";
        } else {
            model.addAttribute("msg", "用户名可用");
            return "register";
        }
    }

    /*注册用户名*/
    @RequestMapping("/register")
    public String register(User user) throws Exception {
        userService.addUser(user);
        return "login";
    }

    /*写简历*/
    @RequestMapping("/writeResume")
    public String writeResume(Resume resume,HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        resume.setU_id(user.getU_id());
        if (resumeService.addResume(resume)) {
            Resume res = resumeService.getResume(user.getU_id());
            session.setAttribute("resume",res);
            return addInterview(session);
        }
        return "error";
    }

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

    /*添加到面试邀请表里*/
    @RequestMapping("/addInterview")
    public String addInterview(HttpSession session) throws Exception {
        Recruiting recruiting = (Recruiting) session.getAttribute("recruiting");//招聘信息
        Resume resume = (Resume) session.getAttribute("resume");//简历
        String interviewDate = MyUtil.toString(new Date());//申请应聘时间
        /*Date date = MyUtil.addDate(new Date());//面试截至时间，3天后
        String interviewTime = MyUtil.toString(date);*/
        interviewService.addInterview(new Interview(recruiting.getP_id(), resume.getRes_id(), 0, interviewDate));
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

    /*邀请面试*/
    @RequestMapping("/comeInterview")
    public String comeInterview(HttpServletRequest request,HttpSession session)throws Exception{
        //request.getParameter("admin_res_id");
        Interview interview = (Interview) session.getAttribute("interview");
        interview.setI_state(2);
        Date date =MyUtil.toDate(interview.getI_interview_time());
        //面试截至时间，3天后
        String interviewTime = MyUtil.toString(MyUtil.addDate(date));
        interview.setI_upto_time(interviewTime);
        interviewService.updateInterview(interview);
        session.setAttribute("interview",interview);
        return "showInterview";
    }
    /*游客查看面试邀请*/
    @RequestMapping("/seeInterview")
    public String seeInterview(HttpSession session)throws Exception{
        User user = (User) session.getAttribute("user");
        Resume resume =resumeService.getResume(user.getU_id());
        List<Interview> list =interviewService.findInterviews(resume.getRes_id());
        List<Interview> iList = new ArrayList<Interview>();
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).getI_state()==2){
                iList.add(list.get(i));
            }
        }
        session.setAttribute("visitor_interview",iList);
        return "visitorInterview";
    }

    /*游客确认参加面试*/
    @RequestMapping("/joinInterview")
    public String joinInterview(HttpServletRequest request,HttpSession session)throws Exception{
        int id = Integer.parseInt(request.getParameter("visitor_i_id"));
        Interview interview =interviewService.getInterview(id);
        interview.setI_state(3);
        interviewService.updateInterview(interview);
        session.setAttribute("interview",interview);
        return "visitor";
    }

    /*管理员查看要录取游客*/
    @RequestMapping("/showAdmitVisitor")
    public String showAdmitVisitor(HttpSession session)throws Exception{
        List<Interview> interviews =interviewService.getInterviewsByState();
        session.setAttribute("admitVisitor",interviews);
        return "admitVisitor";
    }

    /*录用员工*/
    @RequestMapping("/admitVisitor")
    public String admitVisitor(HttpSession session,HttpServletRequest request)throws Exception{
        int id = Integer.parseInt(request.getParameter("admit_visitor_i_id"));
        Interview interview =interviewService.getInterview(id);
        Position position =positionService.getPosition(interview.getP_id());
        Department department = departmentService.getDepart(position.getD_id());
        Recruiting recruiting = recruitingService.getRec(position.getP_id());
        Resume resume =resumeService.findResume(interview.getRes_id());
        String str = resume.getRes_idCard().substring(0,6);
        Employee employee = new Employee(str,str,department.getD_department(),position.getP_position(),
              resume.getRes_gender(),resume.getRes_age(),resume.getRes_birth(),
                MyUtil.toString(new Date()),recruiting.getRec_salary(),resume.getRes_name()  );

        employeeService.addEmp(employee);
        return "admin";
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
    /*添加招聘信息*/
    @RequestMapping("/addRecruiting")
    public String addRecruiting()throws Exception{
        /*recruitingService.addRec();*/
        return "";
    }
}
