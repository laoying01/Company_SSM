package com.laoying.model;

import java.io.Serializable;
import java.util.Date;

public class AwardPunish implements Serializable {
    private int ap_id;
    private double ap_salary;
    private String ap_time;
    private String ap_cause;
    private int emp_id;

    public AwardPunish(double ap_salary, String ap_time, String ap_cause, int emp_id) {
        this.ap_salary = ap_salary;
        this.ap_time = ap_time;
        this.ap_cause = ap_cause;
        this.emp_id = emp_id;
    }

    public AwardPunish() {
    }

    public int getAp_id() {
        return ap_id;
    }

    public void setAp_id(int ap_id) {
        this.ap_id = ap_id;
    }

    public double getAp_salary() {
        return ap_salary;
    }

    public void setAp_salary(double ap_salary) {
        this.ap_salary = ap_salary;
    }

    public String getAp_time() {
        return ap_time;
    }

    public void setAp_time(String ap_time) {
        this.ap_time = ap_time;
    }

    public String getAp_cause() {
        return ap_cause;
    }

    public void setAp_cause(String ap_cause) {
        this.ap_cause = ap_cause;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "AwardPunish{" +
                "ap_id=" + ap_id +
                ", ap_salary=" + ap_salary +
                ", ap_time=" + ap_time +
                ", ap_cause='" + ap_cause + '\'' +
                ", emp_id=" + emp_id +
                '}';
    }
}
