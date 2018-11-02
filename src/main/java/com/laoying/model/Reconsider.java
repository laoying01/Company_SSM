package com.laoying.model;

import org.springframework.format.annotation.DateTimeFormat;
import sun.dc.pr.PRError;

import java.io.Serializable;
import java.util.Date;

public class Reconsider implements Serializable {
    private int r_id;
    private String r_cause;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date r_time;
    private int emp_id;
    private int r_state;//0表示未读，1表示已处理

    public Reconsider() {
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_cause() {
        return r_cause;
    }

    public void setR_cause(String r_cause) {
        this.r_cause = r_cause;
    }

    public Date getR_time() {
        return r_time;
    }

    public void setR_time(Date r_time) {
        this.r_time = r_time;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getR_state() {
        return r_state;
    }

    public void setR_state(int r_state) {
        this.r_state = r_state;
    }

    @Override
    public String toString() {
        return "Reconsider{" +
                "r_id=" + r_id +
                ", r_cause='" + r_cause + '\'' +
                ", r_time=" + r_time +
                ", emp_id=" + emp_id +
                ", r_state=" + r_state +
                '}';
    }
}
