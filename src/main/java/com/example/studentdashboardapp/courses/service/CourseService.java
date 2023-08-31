package com.example.studentdashboardapp.courses.service;

import com.example.studentdashboardapp.courses.model.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);

    Course findById(Long id);

    void deleteById(Long id);

    List<Course> findAll();
}
