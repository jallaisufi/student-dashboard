package com.example.studentdashboardapp.appliactions.service;

import com.example.studentdashboardapp.appliactions.model.Application;
import com.example.studentdashboardapp.courses.model.Course;

public interface ApplicationService {

    Application sendApplication(Course course, String token);

    Application findByStudentId(Long studentId);

    Application updateApplication(Application application);

    void deleteByStudentId(Long studentId);
}
