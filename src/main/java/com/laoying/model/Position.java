package com.laoying.model;

import java.io.Serializable;

public class Position implements Serializable {
    private int p_id;
    private String p_position;

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

    @Override
    public String toString() {
        return "Position{" +
                "p_id=" + p_id +
                ", p_position='" + p_position + '\'' +
                '}';
    }
}
