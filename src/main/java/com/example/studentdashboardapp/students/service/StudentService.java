package com.example.studentdashboardapp.students.service;

import com.example.studentdashboardapp.students.model.Student;

import java.util.List;

public interface StudentService {

    Student registerStudent(Student student);

    Student findById(Long id);

    void deleteById(Long id);

}
