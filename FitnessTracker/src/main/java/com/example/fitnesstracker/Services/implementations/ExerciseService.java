package com.example.fitnesstracker.Services.implementations;

import com.example.fitnesstracker.Entities.Exercise;
import com.example.fitnesstracker.Repositories.ExerciseRepository;
import com.example.fitnesstracker.Services.interfaces.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ExerciseService implements IExerciseService {

    @Autowired
    private final ExerciseRepository exerciseRepository;
    private final Logger logger = Logger.getLogger(ExerciseService.class.getName());

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<Exercise> save(Exercise entity) {
        Optional<Exercise> exerciseOptional = Optional.empty();
        if (entity == null)
            logger.log(Level.SEVERE, "entity must not be null");
        else {
            try {
                exerciseOptional = Optional.ofNullable(exerciseRepository.save(entity));
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to create exercise by name: " + entity.getName());
            }
        }

        return exerciseOptional;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<Exercise> findByName(String name) {
        Optional<Exercise> exerciseOptional = Optional.empty();
        if (name == null || name.trim().isEmpty())
            logger.log(Level.SEVERE, "name cannot be empty");
        else {
            try {
                exerciseOptional = exerciseRepository.findByName(name);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to find exercise by name: " + name);
            }
        }

        return exerciseOptional;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<Exercise> findById(Long id) {
        Optional<Exercise> exerciseOptional = Optional.empty();
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                exerciseOptional = exerciseRepository.findByExerciseId(id);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Failed to find exercise by id: " + id);
            }
        }

        return exerciseOptional;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                exerciseRepository.deleteById(id);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to delete exercise by id: " + id);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public boolean existsById(Long id)  {
        boolean exists = false;
        if (id == null)
            logger.log(Level.SEVERE, "id cannot be null");
        else {
            try {
                exists = exerciseRepository.existsById(id);
            } catch (DataAccessException e) {
                logger.log(Level.SEVERE, "Failed to resolve the request: " + id);
            }
        }

        return exists;
    }
}
