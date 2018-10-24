package com.laoying.dao;

import com.laoying.model.Interview;

import java.util.List;

public interface InterviewDao {
    boolean addInterview(Interview interview);
    List<Interview> getInterviews();//申请面试
    Interview getInterview(int i_id);
    List<Interview> findInterviews(int res_id);
    List<Interview> getInterviewsByState();//通过面试
    boolean updateInterview(Interview interview);
}
