package com.example.fitnesstracker.Repositories;

import com.example.fitnesstracker.Entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise save(Exercise entity);
    Optional<Exercise> findByName(String name);
    Optional<Exercise> findByExerciseId(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);
}
