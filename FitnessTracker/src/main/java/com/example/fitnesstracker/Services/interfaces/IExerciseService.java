package com.example.fitnesstracker.Services.interfaces;

import com.example.fitnesstracker.Entities.Exercise;
import com.example.fitnesstracker.Utils.Exception.ServerException;

import java.util.Optional;

public interface IExerciseService {
    public Optional<Exercise> save(Exercise entity) throws ServerException;
    public Optional<Exercise> findByExerciseId(Long id) throws ServerException;
    public Optional<Exercise> findByName(String name) throws ServerException;
    public void deleteById(Long id) throws ServerException;
    public boolean existsById(Long id) throws ServerException;
}
