package com.example.studentdashboardapp.universities.service;

import com.example.studentdashboardapp.universities.model.University;
import com.example.studentdashboardapp.universities.repository.UniversityRepository;
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
    public University createUniversity(University university) {
        return this.universityRepository.save(university);
    }

    @Override
    public University findById(Long id) {
        Optional<University> universityOptional = this.universityRepository.findById(id);
        if (universityOptional.isPresent()) {
            return universityOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        this.universityRepository.deleteById(id);
    }

    @Override
    public List<University> findAll() {
        return this.universityRepository.findAll();
    }
}
