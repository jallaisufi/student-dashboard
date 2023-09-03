package com.example.studentdashboardapp.appliactions.service;

import com.example.studentdashboardapp.appliactions.model.Application;
import com.example.studentdashboardapp.courses.model.Course;

import java.util.List;

public interface ApplicationService {

    Application sendApplication(Long courseId, Long univeristyid, String token);

    List<Application> findByStudentId(String token);

    Application findById(Long id);

    Application updateApplication(Application application);

    void deleteById(Long id);
}
