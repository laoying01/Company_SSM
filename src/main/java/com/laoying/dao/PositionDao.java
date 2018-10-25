package com.laoying.dao;

import com.laoying.model.Position;

import java.util.List;

public interface PositionDao {
    Position getPosition(int id);
    List<Position> getPositions();
    boolean addPosition(Position position);
    boolean updatePosition(Position position);
    boolean deletePosition(Position position);
    Position findPosition(Position position);
}
