package com.example.fitnesstracker.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "exercises", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 2000)
    private String description;
}
