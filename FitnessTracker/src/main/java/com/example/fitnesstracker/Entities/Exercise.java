package com.example.fitnesstracker.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "exercise", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Exercise {
    @Id
    @GeneratedValue
    private Long exerciseId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}
