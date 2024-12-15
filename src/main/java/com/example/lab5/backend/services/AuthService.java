package com.example.lab5.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lab5.backend.dto.LoginRequest;
import com.example.lab5.backend.dto.CompanyRegistrationRequest;
import com.example.lab5.backend.dto.CandidateRegistrationRequest;
import com.example.lab5.backend.models.Candidate;
import com.example.lab5.backend.models.Company;
import com.example.lab5.backend.repositories.CandidateRepository;
import com.example.lab5.backend.repositories.CompanyRepository;

@Service
public class AuthService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Object login(LoginRequest request) {
        Candidate candidate = candidateRepository.findByEmail(request.getEmail());
        if (candidate != null && passwordEncoder.matches(request.getPassword(), candidate.getPassword())) {
            return candidate;
        }
        
        Company company = companyRepository.findByEmail(request.getEmail());
        if (company != null && passwordEncoder.matches(request.getPassword(), company.getPassword())) {
            return company;
        }
        
        return null;
    }

    public Company registerCompany(CompanyRegistrationRequest request) {
        Company company = new Company();
        company.setName(request.getName());
        company.setEmail(request.getEmail());
        company.setPassword(passwordEncoder.encode(request.getPassword()));
        return companyRepository.save(company);
    }

    public Candidate registerCandidate(CandidateRegistrationRequest request) {
        Candidate candidate = new Candidate();
        candidate.setFullName(request.getFullName());
        candidate.setEmail(request.getEmail());
        candidate.setPassword(passwordEncoder.encode(request.getPassword()));
        return candidateRepository.save(candidate);
    }
}
