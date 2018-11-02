package com.laoying.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class JumpController {
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
    /*跳转填写离职原因页面*/
    @RequestMapping("/goDimission")
    public String goDimission() throws Exception {
        return "addDimission";
    }
    /*跳转添加奖惩信息页面*/
    @RequestMapping("/goAddAwardPunish")
    public String goAddAwardPunish()throws Exception{
        return "addAwardPunish";
    }

    /*跳转添加复议页面*/
    @RequestMapping("/goAddReconsider")
    public String goAddReconsider()throws Exception{
        return "addReconsider";
    }
    /*跳转打卡页面*/
    @RequestMapping("/goAttendance")
    public String goAttendance()throws Exception{
        return "attendance";
    }
}
