package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.Entities.Exercise;
import com.example.fitnesstracker.Services.interfaces.IExerciseService;
import com.example.fitnesstracker.Utils.Exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/exercises/")
public class ExerciseController {

    @Autowired
    private IExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) throws ServerException {
        Optional<Exercise> exerciseOptional = exerciseService.save(exercise);
        return exerciseOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/name")
    public ResponseEntity<Exercise> getExerciseByName(@RequestParam String name) throws ServerException {
        Optional<Exercise> exerciseOptional = exerciseService.findByName(name);
        return exerciseOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/id")
    public ResponseEntity<Exercise> getExerciseById(@RequestParam Long id) throws ServerException {
        Optional<Exercise> exerciseOptional = exerciseService.findByExerciseId(id);
        return exerciseOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteExercise(@RequestParam Long id) throws ServerException {
        if (exerciseService.existsById(id)) {
            exerciseService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
