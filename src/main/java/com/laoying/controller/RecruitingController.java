package com.laoying.controller;

import com.laoying.model.Recruiting;
import com.laoying.service.RecruitingService;
import com.laoying.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class RecruitingController {
    @Autowired
    private RecruitingService recruitingService;

    /*添加招聘信息*/
    @RequestMapping("/addRecruiting")
    public String addRecruiting(Recruiting recruiting, HttpServletRequest request)throws Exception{
        String str = request.getParameter("pid");
        String arr[] = str.split(",");
        recruiting.setP_id(Integer.parseInt(arr[0]));
        recruiting.setRec_time(MyUtil.toString(new Date()));
        recruitingService.addRec(recruiting);
        return "showRecruiting";
    }

    /*跳转修改招聘信息页面*/
    @RequestMapping("/goUpdateRecruiting")
    public String goUpdateRecruiting(HttpSession session,HttpServletRequest request)throws Exception{
       int id = Integer.parseInt(request.getParameter("resId"));
       Recruiting recruiting=recruitingService.findRecruiting(id);
       session.setAttribute("rec",recruiting);
        return "updateRecruiting";
    }
    /*修改招聘信息*/
    @RequestMapping("/updateRecruiting")
    public String updateRecruiting(HttpSession session,Recruiting recruiting)throws Exception{
        recruitingService.updateRec(recruiting);
        return selectRecruiting(session);
    }
    /*删除招聘信息*/
    @RequestMapping("/deleteRecruiting")
    public String deleteRecruiting(HttpSession session,HttpServletRequest request)throws Exception{
        int id = Integer.parseInt(request.getParameter("reId"));
        Recruiting recruiting =recruitingService.findRecruiting(id);
        recruitingService.deleteRec(recruiting);
        return selectRecruiting(session);
    }
    /*查看所有招聘信息*/
    @RequestMapping("/selectRecruiting")
    public String selectRecruiting(HttpSession session)throws Exception{
        List<Recruiting> rList =recruitingService.getRecruiting();
        session.setAttribute("rList",rList);
        return "showRecruiting";
    }
}
