package com.example.studentdashboardapp.students.service;

import com.example.studentdashboardapp.students.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<?> registerStudent(Student student);

    Student findById(Long id);

    void deleteById(Long id);

}
