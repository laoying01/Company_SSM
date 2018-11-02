package com.laoying.service.impl;

import com.laoying.dao.ReconsiderDao;
import com.laoying.dao.RecruitingDao;
import com.laoying.model.Reconsider;
import com.laoying.service.ReconsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReconsiderServiceImpl implements ReconsiderService {
    @Autowired
    private ReconsiderDao reconsiderDao;
    public boolean addReconsider(Reconsider reconsider) {
        return reconsiderDao.addReconsider(reconsider);
    }

    public List<Reconsider> getReconsider() {
        return reconsiderDao.getReconsider();
    }

    public boolean updateReconsider(Reconsider reconsider) {
        return reconsiderDao.updateReconsider(reconsider);
    }

    public Reconsider findReconsider(int r_id) {
        return reconsiderDao.findReconsider(r_id);
    }
}
