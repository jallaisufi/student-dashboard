package com.example.studentdashboardapp.students.repository;

import com.example.studentdashboardapp.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(" from Student s where s.username = :username ")
    Student findByUsername(@Param("username") String username);
}
