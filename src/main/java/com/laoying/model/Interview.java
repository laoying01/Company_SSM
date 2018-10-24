package com.laoying.model;

import java.io.Serializable;
import java.util.Date;

public class Interview implements Serializable {
    private int i_id;
    private int p_id;
    private int res_id;
    private int i_state;//0表示未查看，1表示查看未邀请，2表示查看已邀请，3表示参加面试，4表示面试且通过
    private String i_interview_time;//申请时间
    private String i_upto_time;//面试截至时间

    public Interview() {
    }

    public Interview(int i_id, int p_id, int res_id, int i_state) {
        this.i_id = i_id;
        this.p_id = p_id;
        this.res_id = res_id;
        this.i_state = i_state;
    }

    public Interview(int p_id, int res_id, int i_state, String i_interview_time) {
        this.p_id = p_id;
        this.res_id = res_id;
        this.i_state = i_state;
        this.i_interview_time = i_interview_time;
    }

    public Interview(int p_id, int res_id, int i_state, String i_interview_time, String i_upto_time) {
        this.p_id = p_id;
        this.res_id = res_id;
        this.i_state = i_state;
        this.i_interview_time = i_interview_time;
        this.i_upto_time = i_upto_time;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public int getI_state() {
        return i_state;
    }

    public void setI_state(int i_state) {
        this.i_state = i_state;
    }

    public String getI_interview_time() {
        return i_interview_time;
    }

    public void setI_interview_time(String i_interview_time) {
        this.i_interview_time = i_interview_time;
    }

    public String getI_upto_time() {
        return i_upto_time;
    }

    public void setI_upto_time(String i_upto_time) {
        this.i_upto_time = i_upto_time;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "i_id=" + i_id +
                ", p_id=" + p_id +
                ", res_id=" + res_id +
                ", i_state=" + i_state +
                ", i_interview_time='" + i_interview_time + '\'' +
                ", i_upto_time='" + i_upto_time + '\'' +
                '}';
    }
}
