package com.example.fitnesstracker.Services.implementations;

import com.example.fitnesstracker.Entities.Exercise;
import com.example.fitnesstracker.Entities.MainMuscleGroup;
import com.example.fitnesstracker.Entities.TrainingLog;
import com.example.fitnesstracker.Repositories.MuscleGroupRepository;
import com.example.fitnesstracker.Repositories.TrainingLogRepository;
import com.example.fitnesstracker.Services.interfaces.ITrainingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TrainingLogService implements ITrainingLogService {
    private final TrainingLogRepository trainingLogRepository;
    private final Logger logger = Logger.getLogger(TrainingLogService.class.getName());

    @Autowired
    public TrainingLogService(TrainingLogRepository trainingLogRepository) {
        this.trainingLogRepository = trainingLogRepository;
    }

    @Override
    public TrainingLog save(TrainingLog _trainingLog) {
        TrainingLog trainingLog = null;
        if (_trainingLog == null)
            logger.log(Level.SEVERE, "entity must not be null");
        else {
            try {
                trainingLog = trainingLogRepository.save(_trainingLog);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to create exercise by title: " + _trainingLog.getTitle());
            }
        }

        return trainingLog;
    }

    @Override
    public Optional<TrainingLog> findById(Long id) {
        Optional<TrainingLog> trainingLogOptional = Optional.empty();
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                trainingLogOptional = trainingLogRepository.findById(id);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Failed to find training log by id: " + id);
            }
        }

        return trainingLogOptional;
    }

    @Override
    public Optional<TrainingLog> findByTitle(String title) {
        Optional<TrainingLog> trainingLogOptional = Optional.empty();
        if (title == null || title.trim().isEmpty())
            logger.log(Level.SEVERE, "title cannot be null");
        else {
            try {
                trainingLogOptional = trainingLogRepository.findByTitle(title);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Failed to find training log by title: " + title);
            }
        }

        return trainingLogOptional;
    }

    @Override
    public void deleteById(Long id) {
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                trainingLogRepository.deleteById(id);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to delete training log by id: " + id);
            }
        }
    }
}
