package com.example.studentdashboardapp.universities.service;

import com.example.studentdashboardapp.universities.model.University;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UniversityService {

    ResponseEntity<University> createUniversity(University university);

    ResponseEntity<University> findById(Long id);

    void deleteById(Long id);

    ResponseEntity<List<University>> findAll();
}
