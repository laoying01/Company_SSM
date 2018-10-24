package com.laoying.model;

import sun.dc.pr.PRError;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private int emp_id;
    private String emp_account_number;//账号
    private String emp_pass;
    private int d_id;
    private int p_id;
    private String emp_gender;
    private int emp_age;
    private String emp_birth;
    private String emp_entry_time;//入职时间
    private double emp_salary;
    private String emp_name;
    private int emp_state; //0表示试用期，1表示在职，2表示离职
    public Employee() {
    }

    public Employee(String emp_account_number, String emp_pass) {
        this.emp_account_number = emp_account_number;
        this.emp_pass = emp_pass;
    }

    public Employee(String emp_account_number, String emp_pass, int d_id, int p_id,
                    String emp_gender, int emp_age, String emp_birth, String emp_entry_time,
                    double emp_salary, String emp_name, int emp_state) {
        this.emp_account_number = emp_account_number;
        this.emp_pass = emp_pass;
        this.d_id = d_id;
        this.p_id = p_id;
        this.emp_gender = emp_gender;
        this.emp_age = emp_age;
        this.emp_birth = emp_birth;
        this.emp_entry_time = emp_entry_time;
        this.emp_salary = emp_salary;
        this.emp_name = emp_name;
        this.emp_state = emp_state;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_account_number() {
        return emp_account_number;
    }

    public void setEmp_account_number(String emp_account_number) {
        this.emp_account_number = emp_account_number;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getEmp_state() {
        return emp_state;
    }

    public void setEmp_state(int emp_state) {
        this.emp_state = emp_state;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public String getEmp_birth() {
        return emp_birth;
    }

    public void setEmp_birth(String emp_birth) {
        this.emp_birth = emp_birth;
    }

    public String getEmp_entry_time() {
        return emp_entry_time;
    }

    public void setEmp_entry_time(String emp_entry_time) {
        this.emp_entry_time = emp_entry_time;
    }

    public double getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(double emp_salary) {
        this.emp_salary = emp_salary;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_account_number='" + emp_account_number + '\'' +
                ", emp_pass='" + emp_pass + '\'' +
                ", d_id=" + d_id +
                ", p_id=" + p_id +
                ", emp_gender='" + emp_gender + '\'' +
                ", emp_age=" + emp_age +
                ", emp_birth='" + emp_birth + '\'' +
                ", emp_entry_time='" + emp_entry_time + '\'' +
                ", emp_salary=" + emp_salary +
                ", emp_name='" + emp_name + '\'' +
                ", emp_state=" + emp_state +
                '}';
    }
}
