package com.example.fitnesstracker.Repositories;

import com.example.fitnesstracker.Entities.TrainingLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainingLogRepository extends JpaRepository<TrainingLog, Long> {
    TrainingLog save(TrainingLog trainingLog);
    Optional<TrainingLog> findById(Long id);
    Optional<TrainingLog> findByTitle(String title);
    void deleteById(Long id);
}
