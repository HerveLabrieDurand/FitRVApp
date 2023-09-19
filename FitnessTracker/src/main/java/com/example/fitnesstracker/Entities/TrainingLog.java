package com.example.fitnesstracker.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "training_log")
public class TrainingLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingLogId;

    @Column(nullable = false)
    private String title;
}
