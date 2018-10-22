package com.laoying.service.impl;

import com.laoying.dao.ResumeDao;
import com.laoying.model.Resume;
import com.laoying.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeDao resumeDao;
    public Resume getResume(int u_id) {
         List<Resume> resumes =resumeDao.getResume(u_id);
         if (resumes.size()!=0){
             return resumes.get(0);
         }
         return null;
    }

    public boolean updateResume(Resume resume) {
        return resumeDao.updateResume(resume);
    }

    public boolean addResume(Resume resume) {
        return resumeDao.addResume(resume);
    }

    public List<Resume> getResumes() {
        return resumeDao.getResumes();
    }

    public Resume findResume(int res_id) {
        return resumeDao.findResume(res_id);
    }
}
