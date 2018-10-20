package com.laoying.model;

import java.io.Serializable;

public class Interview implements Serializable {
    private int i_id;
    private int p_id;
    private int res_id;
    private int i_state;

    public Interview() {
    }

    public Interview(int i_id, int p_id, int res_id, int i_state) {
        this.i_id = i_id;
        this.p_id = p_id;
        this.res_id = res_id;
        this.i_state = i_state;
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

    @Override
    public String toString() {
        return "Interview{" +
                "i_id=" + i_id +
                ", p_id=" + p_id +
                ", res_id=" + res_id +
                ", i_state=" + i_state +
                '}';
    }
}
