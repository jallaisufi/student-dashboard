package com.example.studentdashboardapp.courses.service;

import com.example.studentdashboardapp.authentication.service.AuthenticationService;
import com.example.studentdashboardapp.courses.model.Course;
import com.example.studentdashboardapp.courses.repository.CourseRepository;
import com.example.studentdashboardapp.students.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final AuthenticationService authenticationService;

    public CourseServiceImpl(CourseRepository courseRepository, AuthenticationService authenticationService) {
        this.courseRepository = courseRepository;
        this.authenticationService = authenticationService;
    }

    @Override
    public ResponseEntity<Course> createCourse(Course course) {
        return ResponseEntity.ok(this.courseRepository.save(course));
    }

    @Override
    public ResponseEntity<Course> findById(Long id) {
        Optional<Course> courseOptional = this.courseRepository.findById(id);
        return ResponseEntity.ok(courseOptional.orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(this.courseRepository.findAll());
    }

    @Override
    public ResponseEntity<?> findAllByUniversityId(String token, Long universityId) {
        Student loggedInStudent = this.authenticationService.getLoggedInStudent(token);
        if (loggedInStudent != null) {
            return ResponseEntity.ok(this.courseRepository.findAllByUniversityId(universityId));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token not valid");
        }
    }
}
