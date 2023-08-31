package com.example.studentdashboardapp.universities.controller;

import com.example.studentdashboardapp.universities.model.University;
import com.example.studentdashboardapp.universities.service.UniversityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping()
    public University createUniversity(@RequestBody University university) {
        return this.universityService.createUniversity(university);
    }

    @GetMapping("/{id}")
    public University findById(@PathVariable("id") Long id) {
        return this.universityService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        this.universityService.deleteById(id);
    }

    @GetMapping()
    public List<University> findAll() {
        return this.universityService.findAll();
    }
}
