package com.laoying.service;

import com.laoying.model.Recruiting;

import java.util.List;

public interface RecruitingService {
    List<Recruiting> getRecruiting();
    Recruiting findRecruiting(int rec_id);
    Recruiting getRec(int p_id);
}
