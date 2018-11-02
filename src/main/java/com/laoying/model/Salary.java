package com.laoying.model;

import java.io.Serializable;
import java.util.Date;

public class Salary  implements Serializable {
    private int s_id;
    private double s_salary;
    private String s_date;
    private int emp_id;
    private double s_performance;//绩效
    private double s_work_overtime;//加班
    private double s_social_security;//社保

    public Salary() {
    }

    public Salary(double s_salary, String s_date, int emp_id) {
        this.s_salary = s_salary;
        this.s_date = s_date;
        this.emp_id = emp_id;
    }

    public Salary(double s_salary, String s_date, int emp_id, double s_performance,
                  double s_work_overtime, double s_social_security) {
        this.s_salary = s_salary;
        this.s_date = s_date;
        this.emp_id = emp_id;
        this.s_performance = s_performance;
        this.s_work_overtime = s_work_overtime;
        this.s_social_security = s_social_security;
    }

    public double getS_salary() {
        return s_salary;
    }

    public void setS_salary(double s_salary) {
        this.s_salary = s_salary;
    }

    public String getS_date() {
        return s_date;
    }

    public void setS_date(String s_date) {
        this.s_date = s_date;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public double getS_performance() {
        return s_performance;
    }

    public void setS_performance(double s_performance) {
        this.s_performance = s_performance;
    }

    public double getS_work_overtime() {
        return s_work_overtime;
    }

    public void setS_work_overtime(double s_work_overtime) {
        this.s_work_overtime = s_work_overtime;
    }

    public double getS_social_security() {
        return s_social_security;
    }

    public void setS_social_security(double s_social_security) {
        this.s_social_security = s_social_security;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "s_id=" + s_id +
                ", s_salary=" + s_salary +
                ", s_date='" + s_date + '\'' +
                ", emp_id=" + emp_id +
                ", s_performance=" + s_performance +
                ", s_work_overtime=" + s_work_overtime +
                ", s_social_security=" + s_social_security +
                '}';
    }
}
