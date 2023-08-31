package com.example.studentdashboardapp.courses.model;

import com.example.studentdashboardapp.universities.model.University;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_university")
    private University university;
}
