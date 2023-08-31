package com.example.studentdashboardapp.authentication.controller;

import com.example.studentdashboardapp.authentication.model.LoginRequest;
import com.example.studentdashboardapp.authentication.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (authenticationService.authenticateStudent(username, password)) {
            String token = authenticationService.generateToken(username);
            return token;
        }

        return "Invalid credentials";
    }

}
