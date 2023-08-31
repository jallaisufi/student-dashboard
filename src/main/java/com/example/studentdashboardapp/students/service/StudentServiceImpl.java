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
    public Student registerStudent(Student student) {
        Student existingUsername = this.studentRepository.findByUsername(student.getUsername());
        if (existingUsername == null) {
            return this.studentRepository.save(student);
        } else {
            throw new RuntimeException("Username not available!");
        }
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        this.studentRepository.deleteById(id);
    }


}
