package com.example.studentdashboardapp.authentication.service;

import com.example.studentdashboardapp.students.model.Student;
import com.example.studentdashboardapp.students.repository.StudentRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService {

    private final StudentRepository studentRepository;
    private static final String SECRET_KEY = "secretKey";
    private static final long EXPIRATION_TIME = 3600000; // 1 hour

    public AuthenticationService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String generateToken(String username) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean authenticateStudent(String username, String password) {
        Student student = studentRepository.findByUsername(username);
        if (student != null && student.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
