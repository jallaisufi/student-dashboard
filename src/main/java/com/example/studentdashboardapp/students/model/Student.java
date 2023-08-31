package com.example.studentdashboardapp.students.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "survey_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
}