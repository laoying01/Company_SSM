package com.laoying.controller;

import com.laoying.model.Position;
import com.laoying.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PositionController {
    @Autowired
    private PositionService positionService;
    /*跳转添加添加职位页面*/
    @RequestMapping("/goAddPosition")
    public String goAddPosition()throws Exception{
        return "addPosition";
    }
    /*添加职位*/
    @RequestMapping("/addPosition")
    public String addPosition(HttpServletRequest request, Position position)throws Exception{
        Position p=positionService.findPosition(position);
        if (p!=null){
            request.setAttribute("msg","已有该职位");
            return "addPosition";
        }else {
            positionService.addPosition(position);
            return "addPosition";
        }
    }

    /*跳转修改职位*/
    @RequestMapping("/goUpdatePosition")
    public String goUpdatePosition(HttpSession session, HttpServletRequest request)throws Exception{
        int id = Integer.parseInt(request.getParameter("pId"));
        Position p=positionService.getPosition(id);
        session.setAttribute("po",p);
        return "updatePosition";
    }
    /*修改职位信息*/
    @RequestMapping("/updatePosition")
    public String updateRecruiting(HttpSession session,Position position)throws Exception{
        positionService.updatePosition(position);
        return selectPosition(session);
    }
    /*删除职位*/
    @RequestMapping("/deletePosition")
    public String deleteRecruiting(HttpSession session,HttpServletRequest request)throws Exception{
        int id = Integer.parseInt(request.getParameter("pId"));
        Position p=positionService.getPosition(id);
        positionService.deletePosition(p);
        return selectPosition(session);
    }
    /*查看所有职位*/
    @RequestMapping("/selectPosition")
    public String selectPosition(HttpSession session)throws Exception{
        List<Position> pList =positionService.getPositions();
        session.setAttribute("pList",pList);
        return "showPosition";
    }

    /*跳转查看职位二级联动页面*/
    @RequestMapping("/goLookPosition")
    public String goLookPosition(HttpSession session) throws Exception {
        List<Position> pList =positionService.getPositions();
        session.setAttribute("pList",pList);
        return "lookPosition";
    }

    /*换岗二级联动*/
    @RequestMapping()
    public @ResponseBody List<Position> selectPos(HttpServletRequest request)throws Exception{
        int id= Integer.parseInt(request.getParameter("posId"));
        return positionService.getPos(id);
    }
}
