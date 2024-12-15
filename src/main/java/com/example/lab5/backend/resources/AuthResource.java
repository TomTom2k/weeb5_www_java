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

import java.util.Map;

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
        if (user instanceof Candidate) {
            return ResponseEntity.ok("/home?userType=candidate");
        }
        if (user instanceof Company) {
            return ResponseEntity.ok("/home?userType=company&companyId=" + ((Company) user).getId());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> request) {
        String accountType = request.get("accountType");
        
        if ("candidate".equalsIgnoreCase(accountType)) {
            CandidateRegistrationRequest candidateRequest = new CandidateRegistrationRequest(
                request.get("name"),
                request.get("email"),
                request.get("password")
            );
            Candidate candidate = authService.registerCandidate(candidateRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Candidate registered: " + candidate.getFullName());
        } else if ("company".equalsIgnoreCase(accountType)) {
            CompanyRegistrationRequest companyRequest = new CompanyRegistrationRequest(
                request.get("name"),
                request.get("email"),
                request.get("password")
            );
            Company company = authService.registerCompany(companyRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Company registered: " + company.getName());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid account type");
    }
}
