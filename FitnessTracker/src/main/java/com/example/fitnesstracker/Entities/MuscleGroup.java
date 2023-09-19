package com.example.fitnesstracker.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "muscle_group", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class MuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long muscleGroupId;

    @ManyToOne
    @JoinColumn(name="mainMuscleGroupId", nullable=false)
    private MainMuscleGroup mainMuscleGroup;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}