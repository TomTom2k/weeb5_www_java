package com.example.lab5.backend.resources;

import com.example.lab5.backend.models.Candidate;
import com.example.lab5.backend.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateResource {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/{candidateId}")
    public ResponseEntity<Candidate> getCandidate(@PathVariable Long candidateId) {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        return ResponseEntity.ok(candidate);
    }

    @PutMapping("/{candidateId}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long candidateId, @RequestBody Candidate updatedCandidate) {
        Candidate candidate = candidateService.updateCandidate(candidateId, updatedCandidate);
        return ResponseEntity.ok(candidate);
    }
}
