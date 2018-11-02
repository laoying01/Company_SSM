package com.laoying.controller;

import com.laoying.model.Reconsider;
import com.laoying.service.ReconsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ReconsiderController {
    @Autowired
    private ReconsiderService reconsiderService;

    /*添加复议信息*/
    @RequestMapping("/addReconsider")
    public String addReconsider(Reconsider reconsider)throws Exception{
        reconsiderService.addReconsider(reconsider);
        return "employee";
    }
    /*查看复议信息*/
    @RequestMapping("/getReconsider")
    public String getReconsider(HttpSession session)throws Exception{
        List<Reconsider> reconsiders =reconsiderService.getReconsider();
        session.setAttribute("reconsiders",reconsiders);
        return "showReconsider";
    }

    /*返回无效，修改复议信息状态*/
    @RequestMapping("/updateReconsider")
    public String updateReconsider(HttpServletRequest request,HttpSession session)throws Exception{
        Reconsider reconsider =reconsiderService.findReconsider(
                Integer.parseInt(request.getParameter("rId")));
        reconsider.setR_state(1);
        reconsiderService.updateReconsider(reconsider);
        return getReconsider(session);
    }
    /*返回有效，修改复议信息状态*/
    @RequestMapping("/updateRecon")
    public String updateRecon(HttpServletRequest request,HttpSession session)throws Exception{
        int r_id = Integer.parseInt(request.getParameter("r_Id"));
        Reconsider reconsider =reconsiderService.findReconsider(r_id);
        reconsider.setR_state(1);
        reconsiderService.updateReconsider(reconsider);
        return "addAwardPunish";
    }
}
