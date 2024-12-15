package com.example.lab5.frontend.controllers;

import com.example.lab5.backend.models.Job;
import com.example.lab5.backend.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/job/{jobId}")
    public String getJobDetail(@PathVariable Long jobId, Model model) {
        Job job = jobService.getJobById(jobId);
        model.addAttribute("job", job);
        // Add other necessary attributes
        return "job-detail";
    }
} 