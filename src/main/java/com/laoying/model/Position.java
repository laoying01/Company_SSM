package com.laoying.model;

import java.io.Serializable;

public class Position implements Serializable {
    private int p_id;
    private String p_position;
    private int d_id;

    public Position(int p_id, String p_position) {
        this.p_id = p_id;
        this.p_position = p_position;
    }

    public Position() {
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_position() {
        return p_position;
    }

    public void setP_position(String p_position) {
        this.p_position = p_position;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "Position{" +
                "p_id=" + p_id +
                ", p_position='" + p_position + '\'' +
                '}';
    }
}
