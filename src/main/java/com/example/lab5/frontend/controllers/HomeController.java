package com.example.lab5.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
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
