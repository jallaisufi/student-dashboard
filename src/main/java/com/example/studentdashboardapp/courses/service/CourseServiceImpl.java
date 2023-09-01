package com.example.studentdashboardapp.courses.service;

import com.example.studentdashboardapp.courses.model.Course;
import com.example.studentdashboardapp.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course createCourse(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> courseOptional = this.courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            return courseOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public List<Course> findAllByUniversityId(Long universityId) {
        return this.courseRepository.findAllByUniversityId(universityId);
    }
}
