package com.example.studentdashboardapp.appliactions.controller;

import com.example.studentdashboardapp.appliactions.model.Application;
import com.example.studentdashboardapp.appliactions.model.SendApplicationDTO;
import com.example.studentdashboardapp.appliactions.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping()
    public Application sendApplication(@RequestBody SendApplicationDTO dto) {
        return this.applicationService.sendApplication(dto.getCourseId(), dto.getUniversityId(), dto.getToken());
    }

    @GetMapping("/student")
    public List<Application> findAllApplicationsByStudentId(@RequestBody String token) {
        return this.applicationService.findByStudentId(token);
    }

    @GetMapping("/{id}")
    public Application findById(@PathVariable("id") Long id) {
        return this.applicationService.findById(id);
    }

    @PutMapping
    public Application updateApplication(@RequestBody Application application) {
        return this.applicationService.updateApplication(application);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        this.applicationService.deleteById(id);
    }
}
