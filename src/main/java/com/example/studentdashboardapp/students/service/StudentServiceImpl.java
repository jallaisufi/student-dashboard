package com.example.studentdashboardapp.students.service;

import com.example.studentdashboardapp.students.model.Student;
import com.example.studentdashboardapp.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findById(id).get();
    }
}
