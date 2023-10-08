package com.example.fitnesstracker.Repositories;

import com.example.fitnesstracker.Entities.Exercise;
import com.example.fitnesstracker.Entities.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {
    Optional<MuscleGroup> findByName(String name);
    Optional<MuscleGroup> findByMuscleGroupId(Long id);
    boolean existsById(Long id);
}
