package com.example.lab5.frontend.controllers;

import com.example.lab5.backend.models.Job;
import com.example.lab5.backend.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private JobService jobService;

    @GetMapping("/home")
    public String getHomePage(Model model) {
        List<Job> jobs = jobService.findAllJobs();
        model.addAttribute("jobs", jobs);
        return "index";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/create-job")
    public String createJob() {
        return "create-job";
    }

    @GetMapping("/job-detail/{id}")
    public String jobDetail(@PathVariable Long id) {
        return "job-detail";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @GetMapping("/candidate-detail/{id}")
    public String candidateDetail(@PathVariable Long id) {
        return "candidate-detail";
    }

    @GetMapping("/company-detail/{id}")
    public String companyDetail(@PathVariable Long id) {
        return "company-detail";
    }   

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}
