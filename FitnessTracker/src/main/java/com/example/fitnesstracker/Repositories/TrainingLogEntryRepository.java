package com.example.fitnesstracker.Repositories;

import com.example.fitnesstracker.Entities.TrainingLogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingLogEntryRepository extends JpaRepository<TrainingLogEntry, Long> {
    TrainingLogEntry save(TrainingLogEntry entry);
    void deleteById(Long id);
}
