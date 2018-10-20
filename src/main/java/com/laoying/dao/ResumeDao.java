package com.laoying.dao;

import com.laoying.model.Resume;

public interface ResumeDao {
    Resume getResume(int u_id);
    boolean updateResume(Resume resume);
    boolean addResume(Resume resume);
}
