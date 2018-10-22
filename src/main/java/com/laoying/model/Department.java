package com.laoying.model;

import java.io.Serializable;

public class Department implements Serializable {
    private int d_id;
    private String d_department;

    public Department() {
    }

    public Department(int d_id, String d_department) {
        this.d_id = d_id;
        this.d_department = d_department;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_department() {
        return d_department;
    }

    public void setD_department(String d_department) {
        this.d_department = d_department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "d_id=" + d_id +
                ", d_department='" + d_department + '\'' +
                '}';
    }
}
