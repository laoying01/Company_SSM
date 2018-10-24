package com.laoying.controller;

import com.laoying.model.*;
import com.laoying.service.*;
import com.laoying.util.MyUtil;
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
    private InterviewService interviewService;

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
            return "../../index";
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


    /*游客查看面试邀请*/
    @RequestMapping("/seeInterview")
    public String seeInterview(HttpSession session,Model model)throws Exception{
        User user = (User) session.getAttribute("user");
        Resume resume =resumeService.getResume(user.getU_id());
        if(resume==null){
            model.addAttribute("i_msg","您还没有简历");
            return "visitor";
        }
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
}
