package com.laoying.service;

import com.laoying.model.Resume;

import java.util.List;

public interface ResumeService {
    Resume getResume(int u_id);
    boolean updateResume(Resume resume);
    boolean addResume(Resume resume);
    List<Resume> getResumes();
    Resume findResume(int res_id);
}
