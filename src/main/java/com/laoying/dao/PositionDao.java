package com.laoying.dao;

import com.laoying.model.Position;

import java.util.List;

public interface PositionDao {
    Position getPosition(int id);
    List<Position> getPositions();
}
