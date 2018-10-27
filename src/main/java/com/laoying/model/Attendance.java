package com.laoying.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Attendance implements Serializable {
    private int a_id;
    /*@DateTimeFormat(pattern = "")*/
    private Date a_up_work;//上班时间
    private Date a_down_work;//下班时间
    private Date a_date;//当天日期
    private int emp_id;
    private int a_state;//0、正常，1、迟到或早退，2、矿工，3、；

    public Attendance() {
    }

    public Attendance(Date a_up_work, Date a_down_work, Date a_date, int emp_id, int a_state) {
        this.a_up_work = a_up_work;
        this.a_down_work = a_down_work;
        this.a_date = a_date;
        this.emp_id = emp_id;
        this.a_state = a_state;
    }

    public Attendance(Date a_up_work, Date a_date, int emp_id, int a_state) {
        this.a_up_work = a_up_work;
        this.a_date = a_date;
        this.emp_id = emp_id;
        this.a_state = a_state;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public Date getA_up_work() {
        return a_up_work;
    }

    public void setA_up_work(Date a_up_work) {
        this.a_up_work = a_up_work;
    }

    public Date getA_down_work() {
        return a_down_work;
    }

    public void setA_down_work(Date a_down_work) {
        this.a_down_work = a_down_work;
    }

    public Date getA_date() {
        return a_date;
    }

    public void setA_date(Date a_date) {
        this.a_date = a_date;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "a_id=" + a_id +
                ", a_up_work=" + a_up_work +
                ", a_down_work=" + a_down_work +
                ", a_date=" + a_date +
                ", emp_id=" + emp_id +
                ", a_state=" + a_state +
                '}';
    }
}
