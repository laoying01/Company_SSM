package com.laoying.service;

import com.laoying.model.Attendance;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface AttendanceService {
    Attendance getAttByDate(HashMap<String,Object> map);
    boolean addAttByUp(Attendance attendance);
    boolean updateAtt(Attendance attendance);
    List<Attendance> findAttendance();
}
