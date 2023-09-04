package com.example.studentdashboardapp.courses.repository;

import com.example.studentdashboardapp.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(" from Course c " +
            "left join Application a on a.course.id = c.id " +
            "where c.university.id = :universityId and a.id is null")
    List<Course> findAllByUniversityId(@Param("universityId") Long universityId);
}
