package com.example.fitnesstracker.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "muscle_groups", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class MuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long muscleGroupId;

    @ManyToOne
    @JoinColumn(name="main_muscle_group_id", nullable=false)
    private MainMuscleGroup mainMuscleGroup;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 2000)
    private String description;
}