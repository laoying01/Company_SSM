package com.laoying.dao;

import com.laoying.model.Attendance;

import java.util.Date;
import java.util.HashMap;

public interface AttendanceDao {
    Attendance getAttByDate(HashMap<String,Object> map);
    boolean addAttByUp(Attendance attendance);//添加上班打卡
    boolean updateAtt(Attendance attendance);
}
