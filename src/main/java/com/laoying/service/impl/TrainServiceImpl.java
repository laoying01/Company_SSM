package com.laoying.service.impl;

import com.laoying.dao.TrainingDao;
import com.laoying.model.Training;
import com.laoying.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainServiceImpl implements TrainingService {
    @Autowired
    private TrainingDao trainingDao;
    public boolean addTraining(Training training) {
        return trainingDao.addTraining(training);
    }

    public boolean deleteTraining(Training training) {
        return trainingDao.deleteTraining(training);
    }

    public boolean updateTraining(Training training) {
        return trainingDao.updateTraining(training);
    }

    public List<Training> getTraining(int emp_id) {
        return trainingDao.getTraining(emp_id);
    }

    public Training findTraining(int t_id) {
        return trainingDao.findTraining(t_id);
    }

    public List<Training> getTrainings() {
        return trainingDao.getTrainings();
    }
}
