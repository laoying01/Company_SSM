package com.laoying.service.impl;

import com.laoying.dao.ResumeDao;
import com.laoying.model.Resume;
import com.laoying.service.ResumeService;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {
    private ResumeDao resumeDao;

    public Resume getResume(int u_id) {
        return resumeDao.getResume(u_id);
    }

    public boolean updateResume(Resume resume) {
        return resumeDao.updateResume(resume);
    }

    public boolean addResume(Resume resume) {
        return resumeDao.addResume(resume);
    }
}
