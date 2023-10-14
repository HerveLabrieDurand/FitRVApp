package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.Entities.TrainingLogEntry;
import com.example.fitnesstracker.Services.interfaces.ITrainingLogEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/training-log-entries/")
public class TrainingLogEntryController {

    @Autowired
    private ITrainingLogEntryService trainingLogEntryService;

    @PostMapping
    public ResponseEntity<TrainingLogEntry> saveTrainingLogEntry(@RequestBody TrainingLogEntry entity) {
        TrainingLogEntry savedTrainingLogEntry = trainingLogEntryService.save(entity);
        return ResponseEntity.ok(savedTrainingLogEntry);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteTrainingLogEntryById(@RequestParam Long id) {
        trainingLogEntryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
