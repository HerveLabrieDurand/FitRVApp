package com.example.fitnesstracker.Repositories;

import com.example.fitnesstracker.Entities.MainMuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainMuscleGroupRepository extends JpaRepository<MainMuscleGroup, Long> {
    Optional<MainMuscleGroup> findByName(String name);
    Optional<MainMuscleGroup> findByMainMuscleGroupId(Long id);
    boolean existsById(Long id);
}
