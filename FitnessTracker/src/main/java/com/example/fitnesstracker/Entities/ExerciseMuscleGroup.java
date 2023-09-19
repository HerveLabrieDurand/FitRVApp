package com.example.fitnesstracker.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "exercise_muscle_group")
public class ExerciseMuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="exerciseId", nullable=false)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name="muscleGroupId", nullable=false)
    private MuscleGroup muscleGroup;
}
