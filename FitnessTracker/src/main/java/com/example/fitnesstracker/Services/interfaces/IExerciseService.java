package com.example.fitnesstracker.Services.interfaces;

import com.example.fitnesstracker.Entities.Exercise;

import java.util.Optional;

public interface IExerciseService {
    public Optional<Exercise> save(Exercise entity);
    public Optional<Exercise> findById(Long id);
    public Optional<Exercise> findByName(String name);
    public void deleteById(Long id);
    public boolean existsById(Long id);
}
