package com.laoying.dao;

import com.laoying.model.Training;

import java.util.List;

public interface TrainingDao {
    boolean addTraining(Training training);
    boolean deleteTraining(Training training);
    boolean updateTraining(Training training);
    List<Training> getTraining(int emp_id);
    Training findTraining(int t_id);
    List<Training> getTrainings();
}
