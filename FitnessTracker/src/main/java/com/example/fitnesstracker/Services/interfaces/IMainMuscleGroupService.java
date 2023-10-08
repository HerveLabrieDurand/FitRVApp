package com.example.fitnesstracker.Services.interfaces;

import com.example.fitnesstracker.Entities.MainMuscleGroup;
import com.example.fitnesstracker.Entities.MuscleGroup;

import java.util.Optional;

public interface IMainMuscleGroupService {
    public Optional<MainMuscleGroup> findByMainMuscleGroupId(Long id);
    public Optional<MainMuscleGroup> findByName(String name);
}
