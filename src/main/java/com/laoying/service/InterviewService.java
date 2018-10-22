package com.laoying.service;

import com.laoying.model.Interview;

import java.util.List;

public interface InterviewService {
    boolean addInterview(Interview interview);
    List<Interview> getInterviews();
    Interview getInterview(int i_id);
    List<Interview> findInterviews(int res_id);
    List<Interview> getInterviewsByState();
}
