package com.example.fitnesstracker.Services.implementations;

import com.example.fitnesstracker.Entities.TrainingLogEntry;
import com.example.fitnesstracker.Repositories.TrainingLogEntryRepository;
import com.example.fitnesstracker.Services.interfaces.ITrainingLogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TrainingLogEntryService implements ITrainingLogEntryService {
    private final TrainingLogEntryRepository trainingLogRepository;
    private final Logger logger = Logger.getLogger(TrainingLogEntryService.class.getName());

    @Autowired
    public TrainingLogEntryService(TrainingLogEntryRepository trainingLogRepository) {
        this.trainingLogRepository = trainingLogRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public TrainingLogEntry save(TrainingLogEntry entry) {
        TrainingLogEntry trainingLogEntry = null;
        if (entry == null)
            logger.log(Level.SEVERE, "entry must not be null");
        else {
            try {
                trainingLogEntry = trainingLogRepository.save(entry);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to create training log entry by id: " + entry.getTrainingLogEntryId());
            }
        }

        return trainingLogEntry;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                trainingLogRepository.deleteById(id);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to delete training log entry by id: " + id);
            }
        }
    }
}
