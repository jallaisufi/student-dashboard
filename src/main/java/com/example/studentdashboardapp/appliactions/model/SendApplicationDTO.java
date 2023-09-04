package com.example.studentdashboardapp.appliactions.model;

import lombok.Data;

@Data
public class SendApplicationDTO {

    private Long courseId;

    private Long universityId;

    private String token;
}
