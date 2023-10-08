package com.example.fitnesstracker.Services.interfaces;

import com.example.fitnesstracker.Entities.MuscleGroup;

import java.util.Optional;

public interface IMuscleGroupService {
    public Optional<MuscleGroup> findByMuscleGroupId(Long id);
    public Optional<MuscleGroup> findByName(String name);
}
