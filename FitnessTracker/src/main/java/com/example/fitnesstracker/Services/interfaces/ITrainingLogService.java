package com.example.fitnesstracker.Services.interfaces;

import com.example.fitnesstracker.Entities.TrainingLog;

import java.util.Optional;

public interface ITrainingLogService {
    public TrainingLog save(TrainingLog trainingLog);
    public Optional<TrainingLog> findById(Long id);
    public Optional<TrainingLog> findByTitle(String title);
    public void deleteById(Long id);
}
