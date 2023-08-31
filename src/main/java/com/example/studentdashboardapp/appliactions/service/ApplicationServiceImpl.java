package com.example.studentdashboardapp.appliactions.service;

import com.example.studentdashboardapp.appliactions.model.Application;
import com.example.studentdashboardapp.appliactions.model.Status;
import com.example.studentdashboardapp.appliactions.repository.ApplicationRepository;
import com.example.studentdashboardapp.authentication.service.AuthenticationService;
import com.example.studentdashboardapp.courses.model.Course;
import com.example.studentdashboardapp.students.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final AuthenticationService authenticationService;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, AuthenticationService authenticationService) {
        this.applicationRepository = applicationRepository;
        this.authenticationService = authenticationService;
    }

    @Override
    public Application sendApplication(Course course, String token) {
        Student loggedInStudent = this.authenticationService.getLoggedInStudent(token);
        Long maxApplicationNumber = this.applicationRepository.findMaxApplicationNumber();

        Application application = new Application();
        application.setApplyingStudent(loggedInStudent);
        application.setApplicationStatus(Status.PENDING);
        application.setCourse(course);
        application.setApplicationDate(LocalDate.now());
        application.setApplicationNumber(maxApplicationNumber != null ? (maxApplicationNumber + 1) : 1);

        return this.applicationRepository.save(application);
    }

    @Override
    public Application findByStudentId(Long studentId) {
        return this.applicationRepository.findByStudentId(studentId);
    }

    @Override
    public Application updateApplication(Application application) {
        return this.applicationRepository.save(application);
    }

    @Override
    public void deleteByStudentId(Long studentId) {
        this.applicationRepository.deleteById(studentId);
    }
}
