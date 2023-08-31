package com.example.studentdashboardapp.appliactions.model;

import com.example.studentdashboardapp.courses.model.Course;
import com.example.studentdashboardapp.students.model.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "applications")
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "application_number")
    private Long applicationNumber;

    @Column(name = "application_date")
    private LocalDate applicationDate;

    @Column(name = "application_status")
    private Status applicationStatus;

    @ManyToOne
    @JoinColumn(name = "fk_student")
    private Student applyingStudent;

    @ManyToOne
    @JoinColumn(name = "fk_course")
    private Course course;
}
