package com.laoying.dao;

import com.laoying.model.AwardPunish;

import java.util.List;

public interface AwardPunishDao {
    boolean addAwardPunish(AwardPunish awardPunish);
    boolean updateAwardPunish(AwardPunish awardPunish);
    AwardPunish getAwardPunish(int ap_id);
    List<AwardPunish> getAwardPunishs(int emp_id);
    List<AwardPunish> findAwardPunish();
    Double getAp(int emp_id);
}
