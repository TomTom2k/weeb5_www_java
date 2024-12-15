package com.example.lab5.backend.services;

import com.example.lab5.backend.models.Candidate;
import com.example.lab5.backend.models.Job;
import com.example.lab5.backend.repositories.CandidateRepository;
import com.example.lab5.backend.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> getJobsByCompanyId(Long companyId) {
        return jobRepository.findByCompanyId(companyId);
    }

    public void applyForJob(Long jobId, Long candidateId) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
        Candidate candidate = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
        job.getApplicants().add(candidate);
        jobRepository.save(job);
    }

    public List<Candidate> getApplicantsForJob(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
        return job.getApplicants();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }
}
