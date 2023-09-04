package com.example.studentdashboardapp.appliactions.service;

import com.example.studentdashboardapp.appliactions.model.Application;
import com.example.studentdashboardapp.courses.model.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApplicationService {

    ResponseEntity<?> sendApplication(Long courseId, Long univeristyid, String token);

    ResponseEntity<?> findByStudentId(String token);

    ResponseEntity<Application> findById(Long id);

    ResponseEntity<Application> updateApplication(Application application);

    void deleteById(Long id);
}
