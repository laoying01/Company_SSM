package com.laoying.service.impl;

import com.laoying.dao.AwardPunishDao;
import com.laoying.model.AwardPunish;
import com.laoying.service.AwardPunishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AwardPunishServiceImpl implements AwardPunishService {
    @Autowired
    private AwardPunishDao awardPunishDao;
    public boolean addAwardPunish(AwardPunish awardPunish) {
        return awardPunishDao.addAwardPunish(awardPunish);
    }

    public boolean updateAwardPunish(AwardPunish awardPunish) {
        return awardPunishDao.updateAwardPunish(awardPunish);
    }

    public AwardPunish getAwardPunish(int ap_id) {
        return awardPunishDao.getAwardPunish(ap_id);
    }

    public List<AwardPunish> getAwardPunishs(int emp_id) {
        return awardPunishDao.getAwardPunishs(emp_id);
    }

    public List<AwardPunish> findAwardPunish() {
        return awardPunishDao.findAwardPunish();
    }
}
