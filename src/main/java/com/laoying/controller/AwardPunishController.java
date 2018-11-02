package com.laoying.controller;

import com.laoying.model.AwardPunish;
import com.laoying.model.Employee;
import com.laoying.service.AwardPunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AwardPunishController {
    @Autowired
    private AwardPunishService awardPunishService;
    /*添加奖惩信息*/
    @RequestMapping("/addAwardPunish")
    public String addAwardPunish(AwardPunish awardPunish)throws Exception{
        awardPunishService.addAwardPunish(awardPunish);
        return "addAwardPunish";
    }
    /*跳转到修改的页面*/
    @RequestMapping("/goUpdateAwardPunish")
    public String goUpdateAwardPunish(HttpServletRequest request, Model model)throws Exception{
        int id= Integer.parseInt(request.getParameter("apId"));
        AwardPunish awardPunish =awardPunishService.getAwardPunish(id);
        model.addAttribute("awardPunish",awardPunish);
        return "updateAwardPunish";
    }
    /*修改奖惩信息*/
    @RequestMapping("/updateAwardPunish")
    public String updateAwardPunish(AwardPunish awardPunish)throws Exception{
        awardPunishService.updateAwardPunish(awardPunish);
        return "updateAwardPunish";
    }
    /*查询全部*/
    @RequestMapping("/getAwardPunish")
    public String getAwardPunish(HttpSession session)throws Exception{
        List<AwardPunish> awardPunishes =awardPunishService.findAwardPunish();
        session.setAttribute("awardPunishes",awardPunishes);
        return "showAwardPunish";
    }
    /*查看员工自己奖惩信息*/
    @RequestMapping("/showAwardPunish")
    public String showAwardPunish(HttpSession session)throws Exception{
        Employee employee = (Employee) session.getAttribute("employee");
        List<AwardPunish> awardPunishes =awardPunishService.getAwardPunishs(employee.getEmp_id());
        session.setAttribute("emp_ap",awardPunishes);
        return "showEmpAwardPunish";
    }
}
