package com.laoying.service.impl;

import com.laoying.dao.RecruitingDao;
import com.laoying.model.Recruiting;
import com.laoying.service.RecruitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecruitingServiceImpl implements RecruitingService {
    @Autowired
    private RecruitingDao recruitingDao;
    public List<Recruiting> getRecruiting() {
        return recruitingDao.getRecruiting();
    }

    public Recruiting findRecruiting(int rec_id) {
        return recruitingDao.findRecruiting(rec_id);
    }

    public Recruiting getRec(int p_id) {
        return recruitingDao.getRec(p_id);
    }
}
