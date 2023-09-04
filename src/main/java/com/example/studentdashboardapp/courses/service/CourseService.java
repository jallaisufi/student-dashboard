package com.example.studentdashboardapp.courses.service;

import com.example.studentdashboardapp.appliactions.model.Application;
import com.example.studentdashboardapp.courses.model.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

    ResponseEntity<Course> createCourse(Course course);

    ResponseEntity<Course> findById(Long id);

    void deleteById(Long id);

    ResponseEntity<List<Course>> findAll();

    ResponseEntity<?> findAllByUniversityId(String token, Long universityId);
}
