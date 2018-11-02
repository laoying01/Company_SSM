package com.laoying.service;

import com.laoying.model.AwardPunish;

import java.util.List;

public interface AwardPunishService {
    boolean addAwardPunish(AwardPunish awardPunish);
    boolean updateAwardPunish(AwardPunish awardPunish);
    AwardPunish getAwardPunish(int ap_id);
    List<AwardPunish> getAwardPunishs(int emp_id);
    List<AwardPunish> findAwardPunish();
}
