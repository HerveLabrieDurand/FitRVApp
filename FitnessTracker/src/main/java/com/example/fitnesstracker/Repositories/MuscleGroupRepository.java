package com.example.fitnesstracker.Repositories;

import com.example.fitnesstracker.Entities.Exercise;
import com.example.fitnesstracker.Entities.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {
    MuscleGroup save(MuscleGroup muscleGroup);
    Optional<MuscleGroup> findByName(String name);
    Optional<MuscleGroup> findByMuscleGroupId(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
