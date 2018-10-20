package com.laoying.service;

import com.laoying.model.Resume;

public interface ResumeService {
    Resume getResume(int u_id);
    boolean updateResume(Resume resume);
    boolean addResume(Resume resume);
}
