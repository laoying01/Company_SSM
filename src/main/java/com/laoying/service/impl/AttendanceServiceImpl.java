package com.laoying.service.impl;

import com.laoying.dao.AttendanceDao;
import com.laoying.model.Attendance;
import com.laoying.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;
    public Attendance getAttByDate(HashMap<String,Object> map) {
        return attendanceDao.getAttByDate(map);
    }

    public boolean addAttByUp(Attendance attendance) {
        return attendanceDao.addAttByUp(attendance);
    }

    public boolean updateAtt(Attendance attendance) {
        return attendanceDao.updateAtt(attendance);
    }

    public List<Attendance> findAttendance() {
        return attendanceDao.findAttendance();
    }
}
