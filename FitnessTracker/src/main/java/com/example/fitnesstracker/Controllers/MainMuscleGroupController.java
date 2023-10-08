package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.Entities.MainMuscleGroup;
import com.example.fitnesstracker.Entities.MuscleGroup;
import com.example.fitnesstracker.Services.interfaces.IMainMuscleGroupService;
import com.example.fitnesstracker.Services.interfaces.IMuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/main-muscle-groups/")
public class MainMuscleGroupController {

    @Autowired
    private IMainMuscleGroupService mainMuscleGroupService;

    @GetMapping("/name")
    public ResponseEntity<MainMuscleGroup> getMuscleGroupByName(@RequestParam String name) {
        Optional<MainMuscleGroup> muscleGroupOptional = mainMuscleGroupService.findByName(name);
        return muscleGroupOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/id")
    public ResponseEntity<MainMuscleGroup> getMuscleGroupById(@RequestParam Long id) {
        Optional<MainMuscleGroup> muscleGroupOptional = mainMuscleGroupService.findByMainMuscleGroupId(id);
        return muscleGroupOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}