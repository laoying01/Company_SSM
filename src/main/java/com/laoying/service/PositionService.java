package com.laoying.service;

import com.laoying.model.Position;
import javafx.geometry.Pos;

import java.util.List;

public interface PositionService {
    Position getPosition(int id);
    List<Position> getPositions();
    boolean addPosition(Position position);
    boolean updatePosition(Position position);
    boolean deletePosition(Position position);
    Position findPosition(Position position);
}
