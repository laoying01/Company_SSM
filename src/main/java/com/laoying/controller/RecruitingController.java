package com.laoying.controller;

import com.laoying.service.RecruitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecruitingController {
    @Autowired
    private RecruitingService recruitingService;

    /*添加招聘信息*/
    @RequestMapping("/addRecruiting")
    public String addRecruiting()throws Exception{
        /*recruitingService.addRec();*/
        return "";
    }

    /*修改招聘信息*/
    @RequestMapping("/updateRecruiting")
    public String updateRecruiting()throws Exception{
        return "";
    }
}
