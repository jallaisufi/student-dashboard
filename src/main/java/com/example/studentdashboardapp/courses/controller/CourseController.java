package com.example.studentdashboardapp.courses.controller;

import com.example.studentdashboardapp.courses.model.Course;
import com.example.studentdashboardapp.courses.service.CourseService;
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
    public Course createCourse(@RequestBody Course course) {
        return this.courseService.createCourse(course);
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable("id") Long id) {
        return this.courseService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        this.courseService.deleteById(id);
    }

    @GetMapping()
    public List<Course> findAll() {
        return this.courseService.findAll();
    }

    @GetMapping("/university/{universityId}")
    public List<Course> findAllByUniversityId(@PathVariable("universityId") Long universityId) {
        return this.courseService.findAllByUniversityId(universityId);
    }
}
