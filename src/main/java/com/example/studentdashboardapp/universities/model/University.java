package com.example.studentdashboardapp.universities.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;

@Entity
@Table(name = "universities")
@Data
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;
}
