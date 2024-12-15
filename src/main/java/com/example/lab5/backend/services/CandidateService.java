package com.example.lab5.backend.services;

import com.example.lab5.backend.models.Candidate;
import com.example.lab5.backend.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService implements IService<Candidate> {
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate save(Candidate entity) {
        return candidateRepository.save(entity);
    }   

    @Override
    public Candidate update(Candidate entity) {
        return candidateRepository.save(entity);
    }   

    @Override
    public Candidate delete(Candidate entity) {
        candidateRepository.delete(entity);
        return entity;
    }

    @Override
    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId)
            .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    public Candidate updateCandidate(Long candidateId, Candidate updatedCandidate) {
        Candidate candidate = getCandidateById(candidateId);
        candidate.setName(updatedCandidate.getName());
        candidate.setEmail(updatedCandidate.getEmail());
        // Update other fields as necessary
        return candidateRepository.save(candidate);
    }
}
