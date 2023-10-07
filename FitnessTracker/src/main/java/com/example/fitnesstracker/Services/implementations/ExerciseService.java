package com.example.fitnesstracker.Services.implementations;

import com.example.fitnesstracker.Entities.Exercise;
import com.example.fitnesstracker.Repositories.ExerciseRepository;
import com.example.fitnesstracker.Services.interfaces.IExerciseService;
import com.example.fitnesstracker.Utils.Exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class ExerciseService implements IExerciseService {

    @Autowired
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<Exercise> save(Exercise entity) throws ServerException {
        Assert.notNull(entity, "entity cannot be null");
        Optional<Exercise> exerciseOptional = Optional.empty();
        try {
            exerciseOptional = Optional.ofNullable(exerciseRepository.save(entity));
        } catch (DataAccessException e) {
            throw new ServerException("Failed to create exercise by name: " + entity.getName(), e);
        }
        return exerciseOptional;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<Exercise> findByName(String name) throws ServerException {
        Assert.hasText(name, "name cannot be empty");
        Optional<Exercise> exerciseOptional = Optional.empty();
        try {
            exerciseOptional = exerciseRepository.findByName(name);
        } catch (DataAccessException e) {
            throw new ServerException("Failed to find exercise by name: " + name, e);
        }
        return exerciseOptional;
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public Optional<Exercise> findByExerciseId(Long id) throws ServerException {
        Assert.notNull(id, "id cannot be null");
        Optional<Exercise> exerciseOptional = Optional.empty();
        try {
            exerciseOptional = exerciseRepository.findByExerciseId(id);
        } catch (DataAccessException e) {
            throw new ServerException("Failed to find exercise by id: " + id, e);
        }
        return exerciseOptional;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) throws ServerException {
        Assert.notNull(id, "id cannot be null");
        try {
            exerciseRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new ServerException("Failed to delete exercise by id: " + id, e);
        }
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public boolean existsById(Long id) throws ServerException {
        Assert.notNull(id, "id cannot be null");
        try {
            return exerciseRepository.existsById(id);
        } catch (DataAccessException e) {
            throw new ServerException("Failed to resolve the request: " + id, e);
        }
    }
}

