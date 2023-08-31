package com.example.studentdashboardapp.students.service;

import com.example.studentdashboardapp.students.model.Student;

public interface StudentService {

    Student createStudent(Student student);

    Student findById(Long id);

}
