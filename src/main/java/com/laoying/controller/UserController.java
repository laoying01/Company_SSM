package com.laoying.controller;

import com.laoying.model.User;
import com.laoying.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    /*跳转登录页面*/
    @RequestMapping("/goLogin")
    public String goLogin()throws Exception{
        return "login";
    }
    /*跳转注册页面*/
    @RequestMapping("/goRegister")
    public String goRegister()throws Exception{
        return "register";
    }
    /*登录*/
    @RequestMapping("/login")
    public String login(User user, HttpSession session) throws Exception{
        User user1 =userService.getUser(user);
        if (user1!=null){
            session.setAttribute("user",user1);
            return "../../index";
        }else {
            return "error";
        }
    }
    /*注册验证用户名*/
    @RequestMapping("/verifyRegister")
    public String verifyRegister(HttpServletRequest request, Model model)throws Exception{
        String name =request.getParameter("u_name");
        User user =userService.getUser(new User(name));
        if (user!=null){
            model.addAttribute("msg","用户名已存在");
            return "register";
        }else {
            model.addAttribute("msg","用户名可用");
            return "register";
        }
    }
    /*注册用户名*/
    @RequestMapping("/register")
    public String register(User user)throws Exception{
       userService.addUser(user);
       return "login";
    }
}
