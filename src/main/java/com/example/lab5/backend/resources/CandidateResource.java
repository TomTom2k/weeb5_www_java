package com.example.lab5.backend.resources;

import com.example.lab5.backend.models.Candidate;
import com.example.lab5.backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateResource {
    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public List<Candidate> getCandidates() {
        return candidateService.findAll();
    }
}
