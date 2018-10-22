package com.laoying.dao;

import com.laoying.model.Recruiting;

import java.util.List;

public interface RecruitingDao {
    List<Recruiting> getRecruiting();
    Recruiting findRecruiting(int rec_id);
    Recruiting getRec(int p_id);
}
