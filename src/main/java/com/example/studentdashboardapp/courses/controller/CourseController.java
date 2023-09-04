package com.example.studentdashboardapp.courses.controller;

import com.example.studentdashboardapp.appliactions.model.Application;
import com.example.studentdashboardapp.courses.model.Course;
import com.example.studentdashboardapp.courses.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping()
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return this.courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Long id) {
        return this.courseService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        this.courseService.deleteById(id);
    }

    @GetMapping()
    public ResponseEntity<List<Course>> findAll() {
        return this.courseService.findAll();
    }

    @GetMapping("/university/{universityId}")
    public ResponseEntity<?> findAllByUniversityId(@RequestHeader String token, @PathVariable("universityId") Long universityId) {
        return this.courseService.findAllByUniversityId(token, universityId);
    }
}
