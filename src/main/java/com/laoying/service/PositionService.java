package com.laoying.service;

import com.laoying.model.Position;
import javafx.geometry.Pos;

import java.util.List;

public interface PositionService {
    Position getPosition(int id);
    List<Position> getPositions();
}
