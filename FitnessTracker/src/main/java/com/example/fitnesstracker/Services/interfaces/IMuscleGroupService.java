package com.example.fitnesstracker.Services.interfaces;

import com.example.fitnesstracker.Entities.MuscleGroup;

import java.util.Optional;

public interface IMuscleGroupService {
    public Optional<MuscleGroup> save(MuscleGroup entity);
    public Optional<MuscleGroup> findByMuscleGroupId(Long id);
    public Optional<MuscleGroup> findByName(String name);
    public void deleteById(Long id);
    public boolean existsById(Long id);
}
