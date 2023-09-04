package com.example.studentdashboardapp.universities.service;

import com.example.studentdashboardapp.universities.model.University;
import com.example.studentdashboardapp.universities.repository.UniversityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public ResponseEntity<University> createUniversity(University university) {
        return ResponseEntity.ok(this.universityRepository.save(university));
    }

    @Override
    public ResponseEntity<University> findById(Long id) {
        Optional<University> universityOptional = this.universityRepository.findById(id);
        return ResponseEntity.ok(universityOptional.orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        this.universityRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<List<University>> findAll() {
        return ResponseEntity.ok(this.universityRepository.findAll());
    }
}
