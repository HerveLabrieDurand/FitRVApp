package com.example.fitnesstracker.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "training_log_entry")
public class TrainingLogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingLogEntryId;

    @ManyToOne
    @JoinColumn(name="exerciseId", nullable=false)
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name="trainingLogId", nullable=false)
    private TrainingLog trainingLog;

    @Column(nullable = false)
    private int sets;

    @Column(nullable = false)
    private int reps;

    @Column(nullable = false, precision=6, scale=2)
    private float weight;

    @Column(nullable = false)
    private int intensity;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private String notes;
}