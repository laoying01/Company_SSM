package com.laoying.service;

import com.laoying.model.Training;

import java.util.List;

public interface TrainingService {
    boolean addTraining(Training training);
    boolean deleteTraining(Training training);
    boolean updateTraining(Training training);
    List<Training> getTraining(int emp_id);//通过员工id查找
    Training findTraining(int t_id);
    List<Training> getTrainings();
}
