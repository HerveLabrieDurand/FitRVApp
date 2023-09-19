package com.example.fitnesstracker.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "main_muscle_group", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class MainMuscleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainMuscleGroupId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
