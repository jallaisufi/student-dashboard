package com.example.studentdashboardapp.appliactions.repository;

import com.example.studentdashboardapp.appliactions.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Query("select max(a.applicationNumber) from Application a")
    Long findMaxApplicationNumber();

    @Query("from Application a where a.applyingStudent.id = :studentId")
    List<Application> findByStudentId(@Param("studentId") Long studentId);
}
