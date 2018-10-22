package com.laoying.service.impl;

import com.laoying.dao.InterviewDao;
import com.laoying.model.Interview;
import com.laoying.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewDao interviewDao;
    public boolean addInterview(Interview interview) {
        return interviewDao.addInterview(interview);
    }

    public List<Interview> getInterviews() {
        return interviewDao.getInterviews();
    }

    public Interview getInterview(int i_id) {
        return interviewDao.getInterview(i_id);
    }

    public List<Interview> findInterviews(int res_id) {
        return interviewDao.findInterviews(res_id);
    }

    public List<Interview> getInterviewsByState() {
        return interviewDao.getInterviewsByState();
    }
}