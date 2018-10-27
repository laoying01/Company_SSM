package com.laoying.controller;

import com.laoying.model.Attendance;
import com.laoying.service.AttendanceService;
import com.laoying.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@Controller
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    /*添加一条考勤记录*/
    @RequestMapping("/addAttendance")
    public String addAttendance(HttpServletRequest request, Model model)throws Exception{
        int id = Integer.parseInt(request.getParameter("empId"));//员工id
        Date newDate = new Date(); //系统当前时间  既上班打卡时间
        String date = MyUtil.toString(newDate);
        String date1 = MyUtil.toString1(newDate);//转为string为了去到层做比较,上班打卡时间的String类型
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("newDate",date1);
        map.put("emp_id",id);
        Attendance attendance =attendanceService.getAttByDate(map);
        if (attendance!=null){//为null说明没有记录  新增上班时间
            if (attendance.getA_down_work()==null){//判断下班时间是否为null，true添加下班时间，false显示您打卡成功
                Date downDate = new Date();//下班打卡时间
                //String workTime = MyUtil.toString(downDate);//下班打卡时间字符串
                String str =date.substring(0,11);//当天时间的年月日截取
                String upTime= str+"09:00:00";//上班时间的字符串
                String downTime = str+"18:00:00";//下班时间的字符串
                Date upDate = MyUtil.toDate(upTime);//上班时间
                Date workDate =MyUtil.toDate(downTime);//下班时间
                long time1=newDate.getTime();//上班打卡时间ms
                long time2 =downDate.getTime();//下班打卡时间ms
                long time3=upDate.getTime();//上班时间ms
                long time4 = workDate.getTime();//下班时间ms
                if(time1-time3>0 ||time4-time2>0){
                    if(((time1-time3)+(time4-time2))/1000>=10800){
                        attendance.setA_state(2);
                    }else {
                        attendance.setA_state(1);
                    }
                }
                attendance.setA_down_work(downDate);
                attendanceService.updateAtt(attendance);
            }else {
                model.addAttribute("msg","已经打过卡了");

            }
        }else {
            attendanceService.addAttByUp(new Attendance(newDate,MyUtil.dateToDate(newDate),id,0));
        }
        return "employee";
    }
}
