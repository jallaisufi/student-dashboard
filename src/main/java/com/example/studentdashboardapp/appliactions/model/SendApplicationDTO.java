package com.example.studentdashboardapp.appliactions.model;

import com.example.studentdashboardapp.courses.model.Course;
import lombok.Data;

@Data
public class SendApplicationDTO {

    private Long courseId;

    private Long universityId;

    private String token;
}
