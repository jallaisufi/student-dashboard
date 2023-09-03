package com.example.studentdashboardapp.students.service;

import com.example.studentdashboardapp.students.model.Student;
import com.example.studentdashboardapp.students.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<?> registerStudent(Student student) {
        if (student == null || student.getUsername().isEmpty() || student.getPassword().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: User credentials are not completed");
        }

        Student existingUsername = this.studentRepository.findByUsername(student.getUsername());
        if (existingUsername == null) {
            return ResponseEntity.ok(this.studentRepository.save(student));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username not available");
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
