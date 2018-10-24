package com.laoying.service.impl;

import com.laoying.dao.PositionDao;
import com.laoying.model.Position;
import com.laoying.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;
    public Position getPosition(int id) {

        return positionDao.getPosition(id);
    }

    public List<Position> getPositions() {
        return positionDao.getPositions();
    }
}
