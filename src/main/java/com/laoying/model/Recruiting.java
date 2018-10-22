package com.laoying.model;

import java.io.Serializable;

public class Recruiting implements Serializable {
    private int rec_id;
    private double rec_salary;
    private String rec_position_statement;
    private int p_id;
    private String rec_time;

    public Recruiting() {
    }

    public Recruiting(int rec_id, double rec_salary, String rec_position_statement, int p_id) {
        this.rec_id = rec_id;
        this.rec_salary = rec_salary;
        this.rec_position_statement = rec_position_statement;
        this.p_id = p_id;
    }

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    public double getRec_salary() {
        return rec_salary;
    }

    public void setRec_salary(double rec_salary) {
        this.rec_salary = rec_salary;
    }

    public String getRec_position_statement() {
        return rec_position_statement;
    }

    public void setRec_position_statement(String rec_position_statement) {
        this.rec_position_statement = rec_position_statement;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getRec_time() {
        return rec_time;
    }

    public void setRec_time(String rec_time) {
        this.rec_time = rec_time;
    }

    @Override
    public String toString() {
        return "Recruiting{" +
                "rec_id=" + rec_id +
                ", rec_salary=" + rec_salary +
                ", rec_position_statement='" + rec_position_statement + '\'' +
                ", p_id=" + p_id +
                ", rec_time='" + rec_time + '\'' +
                '}';
    }
}
