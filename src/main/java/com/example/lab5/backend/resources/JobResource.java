package com.example.lab5.backend.resources;

import com.example.lab5.backend.models.Job;
import com.example.lab5.backend.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobResource {
    @Autowired
    private JobService jobService;

    @GetMapping("/home")
    public List<Job> getJobs(@RequestParam String userType, @RequestParam(required = false) Long companyId) {
        if ("candidate".equalsIgnoreCase(userType)) {
            return jobService.getAllJobs();
        } else if ("company".equalsIgnoreCase(userType) && companyId != null) {
            return jobService.getJobsByCompanyId(companyId);
        }
        return List.of(); // Return an empty list if no valid userType is provided
    }

    @PostMapping("/apply")
    public ResponseEntity<String> applyForJob(@RequestParam Long jobId, @RequestParam Long candidateId) {
        jobService.applyForJob(jobId, candidateId);
        return ResponseEntity.ok("Application successful");
    }

    @GetMapping("/job/{jobId}/applicants")
    public List<Candidate> getApplicants(@PathVariable Long jobId) {
        return jobService.getApplicantsForJob(jobId);
    }

    @PostMapping("/job")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
    }
}
