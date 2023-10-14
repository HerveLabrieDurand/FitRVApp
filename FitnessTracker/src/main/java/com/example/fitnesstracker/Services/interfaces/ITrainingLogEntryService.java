package com.example.fitnesstracker.Services.interfaces;

import com.example.fitnesstracker.Entities.TrainingLogEntry;

public interface ITrainingLogEntryService {
    public TrainingLogEntry save(TrainingLogEntry entity);
    public void deleteById(Long id);
}
