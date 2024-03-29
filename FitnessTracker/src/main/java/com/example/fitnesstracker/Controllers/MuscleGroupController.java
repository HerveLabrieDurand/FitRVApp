package com.example.fitnesstracker.Controllers;

import com.example.fitnesstracker.Entities.MuscleGroup;
import com.example.fitnesstracker.Services.interfaces.IMuscleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/muscle-groups/")
public class MuscleGroupController {

    @Autowired
    private IMuscleGroupService muscleGroupService;

    @GetMapping("/name")
    public ResponseEntity<MuscleGroup> getMuscleGroupByName(@RequestParam String name) {
        Optional<MuscleGroup> muscleGroupOptional = muscleGroupService.findByName(name);
        return muscleGroupOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/id")
    public ResponseEntity<MuscleGroup> getMuscleGroupById(@RequestParam Long id) {
        Optional<MuscleGroup> muscleGroupOptional = muscleGroupService.findByMuscleGroupId(id);
        return muscleGroupOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

