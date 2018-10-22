package com.laoying.service.impl;

import com.laoying.dao.DepartmentDao;
import com.laoying.model.Department;
import com.laoying.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    public Department getDepart(int d_id) {
        return departmentDao.getDepart(d_id);
    }
}
