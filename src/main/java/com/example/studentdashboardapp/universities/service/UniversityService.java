package com.example.studentdashboardapp.universities.service;

import com.example.studentdashboardapp.universities.model.University;

import java.util.List;

public interface UniversityService {

    University createUniversity(University university);

    University findById(Long id);

    void deleteById(Long id);

    List<University> findAll();
}
