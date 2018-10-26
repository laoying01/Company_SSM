package com.laoying.service.impl;

import com.laoying.dao.EmployeeDao;
import com.laoying.dao.PositionDao;
import com.laoying.model.Employee;
import com.laoying.model.Position;
import com.laoying.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private EmployeeDao employeeDao;
    public Position getPosition(int id) {

        return positionDao.getPosition(id);
    }

    public List<Position> getPositions() {
        return positionDao.getPositions();
    }

    public boolean addPosition(Position position) {
        return positionDao.addPosition(position);
    }

    public boolean updatePosition(Position position) {
        return positionDao.updatePosition(position);
    }

    public boolean deletePosition(Position position) {
        List<Employee> employees =employeeDao.findEmployees(position.getP_id());
        if (employees.size()!=0){
            return false;
        }else {
            positionDao.deletePosition(position);
            return true;
        }

    }

    public Position findPosition(Position position) {
        return positionDao.findPosition(position);
    }

    public List<Position> getPos(int d_id) {
        return positionDao.getPos(d_id);
    }
}
