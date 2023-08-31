package com.example.studentdashboardapp.universities.repository;

import com.example.studentdashboardapp.universities.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
