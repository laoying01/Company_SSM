package com.laoying.service;

import com.laoying.model.Attendance;

import java.util.Date;
import java.util.HashMap;

public interface AttendanceService {
    Attendance getAttByDate(HashMap<String,Object> map);
    boolean addAttByUp(Attendance attendance);
    boolean updateAtt(Attendance attendance);
}
