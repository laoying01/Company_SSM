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

}
