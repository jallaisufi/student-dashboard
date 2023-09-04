package com.example.studentdashboardapp.students.controller;

import com.example.studentdashboardapp.students.model.Student;
import com.example.studentdashboardapp.students.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<?> registerdStudent(@RequestBody Student student) {
        return this.studentService.registerStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id) {
        return this.studentService.findById(id);
    }
}
