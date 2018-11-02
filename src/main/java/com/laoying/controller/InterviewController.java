package com.laoying.controller;

import com.laoying.model.Interview;
import com.laoying.model.Recruiting;
import com.laoying.model.Resume;
import com.laoying.service.InterviewService;
import com.laoying.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class InterviewController {
    @Autowired
    private InterviewService interviewService;


    /*管理员查看要录取游客*/
    @RequestMapping("/showAdmitVisitor")
    public String showAdmitVisitor(HttpSession session)throws Exception{
        List<Interview> interviews =interviewService.getInterviewsByState();
        session.setAttribute("admitVisitor",interviews);
        return "admitVisitor";
    }

    /*邀请面试*/
    @RequestMapping("/comeInterview")
    public String comeInterview(HttpServletRequest request, HttpSession session)throws Exception{
        //request.getParameter("admin_res_id");
        Interview interview = (Interview) session.getAttribute("interview");
        interview.setI_state(2);
        Date date = MyUtil.toDate(interview.getI_interview_time());
        //面试截至时间，3天后
        String interviewTime = MyUtil.toString(MyUtil.addDate(date));
        interview.setI_upto_time(interviewTime);
        interviewService.updateInterview(interview);
        session.setAttribute("interview",interview);
        return "showInterview";
    }

    /*游客确认参加面试*/
    @RequestMapping("/joinInterview")
    public String joinInterview(HttpServletRequest request,HttpSession session)throws Exception{
        int id = Integer.parseInt(request.getParameter("visitor_i_id"));
        Interview interview =interviewService.getInterview(id);
        interview.setI_state(3);
        interviewService.updateInterview(interview);
        session.setAttribute("interview",interview);
        return "visitorInterview";
    }
}
