package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.Entities.TrainingLog;
import com.example.fitnesstracker.Services.interfaces.ITrainingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/training-logs/")
public class TrainingLogController {

    @Autowired
    private ITrainingLogService trainingLogService;

    @PostMapping
    public ResponseEntity<TrainingLog> saveTrainingLog(@RequestBody TrainingLog trainingLog) {
        TrainingLog savedTrainingLog = trainingLogService.save(trainingLog);
        return ResponseEntity.ok(savedTrainingLog);
    }

    @GetMapping("/id")
    public ResponseEntity<TrainingLog> getTrainingLogById(@RequestParam Long id) {
        Optional<TrainingLog> trainingLogOptional = trainingLogService.findById(id);
        return trainingLogOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/title")
    public ResponseEntity<TrainingLog> getTrainingLogByTitle(@RequestParam String title) {
        Optional<TrainingLog> trainingLogOptional = trainingLogService.findByTitle(title);
        return trainingLogOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteTrainingLogById(@RequestParam Long id) {
        trainingLogService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
