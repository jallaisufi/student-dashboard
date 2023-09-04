package com.example.studentdashboardapp.appliactions.service;

import com.example.studentdashboardapp.appliactions.model.Application;
import com.example.studentdashboardapp.appliactions.model.Status;
import com.example.studentdashboardapp.appliactions.repository.ApplicationRepository;
import com.example.studentdashboardapp.authentication.service.AuthenticationService;
import com.example.studentdashboardapp.courses.model.Course;
import com.example.studentdashboardapp.courses.repository.CourseRepository;
import com.example.studentdashboardapp.students.model.Student;
import com.example.studentdashboardapp.universities.model.University;
import com.example.studentdashboardapp.universities.repository.UniversityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final AuthenticationService authenticationService;
    private final UniversityRepository universityRepository;
    private final CourseRepository courseRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, AuthenticationService authenticationService, UniversityRepository universityRepository, CourseRepository courseRepository) {
        this.applicationRepository = applicationRepository;
        this.authenticationService = authenticationService;
        this.universityRepository = universityRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public ResponseEntity<?> sendApplication(Long courseId, Long univeristyId, String token) {
        Student loggedInStudent = this.authenticationService.getLoggedInStudent(token);
        Long maxApplicationNumber = this.applicationRepository.findMaxApplicationNumber();
        Optional<Course> selectedCourse = this.courseRepository.findById(courseId);
        Optional<University> selectedUniversity = this.universityRepository.findById(univeristyId);

        if (selectedCourse.isPresent() && selectedUniversity.isPresent()) {
            Application application = new Application();
            application.setApplyingStudent(loggedInStudent);
            application.setApplicationStatus(Status.PENDING);
            application.setCourse(selectedCourse.get());
            application.setApplicationDate(LocalDate.now());
            application.setApplicationNumber(maxApplicationNumber != null ? (maxApplicationNumber + 1) : 1);

            return ResponseEntity.ok(this.applicationRepository.save(application));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Select both university and course");
        }
    }

    @Override
    public ResponseEntity<?> findByStudentId(String token) {
        Student loggedInStudent = this.authenticationService.getLoggedInStudent(token);
        if (loggedInStudent != null) {
            return ResponseEntity.ok(this.applicationRepository.findByStudentId(loggedInStudent.getId()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token not valid");
        }
    }

    @Override
    public ResponseEntity<Application> findById(Long id) {
        Optional<Application> optionalApplication = this.applicationRepository.findById(id);
        return ResponseEntity.ok(optionalApplication.orElse(null));
    }

    @Override
    public ResponseEntity<Application> updateApplication(Application application) {
        return ResponseEntity.ok(this.applicationRepository.save(application));
    }

    @Override
    public void deleteById(Long id) {
        this.applicationRepository.deleteById(id);
    }
}
