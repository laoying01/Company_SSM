package com.laoying.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Training implements Serializable {
    private int t_id;
    private String t_theme;//主题
    private String t_content;//培训内容
    private String t_start_time;
    private String t_end_time;
    private int emp_id;
    private String t_address;

    public Training() {
    }

    public Training(int t_id, String t_theme, String t_content, String t_start_time, String t_end_time,
                    int emp_id, String t_address) {
        this.t_id = t_id;
        this.t_theme = t_theme;
        this.t_content = t_content;
        this.t_start_time = t_start_time;
        this.t_end_time = t_end_time;
        this.emp_id = emp_id;
        this.t_address = t_address;
    }

    public Training(String t_theme, String t_content, String t_start_time, String t_end_time, int emp_id,
                    String t_address) {
        this.t_theme = t_theme;
        this.t_content = t_content;
        this.t_start_time = t_start_time;
        this.t_end_time = t_end_time;
        this.emp_id = emp_id;
        this.t_address = t_address;
    }

    public Training(String t_theme, String t_content, String t_start_time, String t_end_time, String t_address) {
        this.t_theme = t_theme;
        this.t_content = t_content;
        this.t_start_time = t_start_time;
        this.t_end_time = t_end_time;
        this.t_address = t_address;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_theme() {
        return t_theme;
    }

    public void setT_theme(String t_theme) {
        this.t_theme = t_theme;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getT_start_time() {
        return t_start_time;
    }

    public void setT_start_time(String t_start_time) {
        this.t_start_time = t_start_time;
    }

    public String getT_end_time() {
        return t_end_time;
    }

    public void setT_end_time(String t_end_time) {
        this.t_end_time = t_end_time;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    @Override
    public String toString() {
        return "Training{" +
                "t_id=" + t_id +
                ", t_theme='" + t_theme + '\'' +
                ", t_content='" + t_content + '\'' +
                ", t_start_time=" + t_start_time +
                ", t_end_time=" + t_end_time +
                ", emp_id=" + emp_id +
                ", t_address='" + t_address + '\'' +
                '}';
    }
}