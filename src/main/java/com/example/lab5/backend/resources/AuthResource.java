package com.example.lab5.backend.resources;

import org.springframework.web.bind.annotation.RestController;

import com.example.lab5.backend.dto.LoginRequest;
import com.example.lab5.backend.models.Candidate;
import com.example.lab5.backend.models.Company;
import com.example.lab5.backend.services.AuthService;
import com.example.lab5.backend.dto.CompanyRegistrationRequest;
import com.example.lab5.backend.dto.CandidateRegistrationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        Object user = authService.login(request);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        if(user instanceof Candidate) {
            return ResponseEntity.ok("Candidate logged in: " + ((Candidate) user).getFullName());
        }
        if(user instanceof Company) {
            return ResponseEntity.ok("Company logged in: " + ((Company) user).getName());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
    }

    @PostMapping("/register/company")
    public ResponseEntity<String> registerCompany(@RequestBody CompanyRegistrationRequest request) {
        Company company = authService.registerCompany(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Company registered: " + company.getName());
    }

    @PostMapping("/register/candidate")
    public ResponseEntity<String> registerCandidate(@RequestBody CandidateRegistrationRequest request) {
        Candidate candidate = authService.registerCandidate(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Candidate registered: " + candidate.getFullName());
    }
}
