package com.example.lab5.backend.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany
    private List<JobSkill> jobSkills;   

    @ManyToMany
    @JoinTable(
        name = "job_applications",
        joinColumns = @JoinColumn(name = "job_id"),
        inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private List<Candidate> applicants = new ArrayList<>();

    public Job(String name, String description, Company company) {
        this.name = name;
        this.description = description;
        this.company = company;
        this.jobSkills = new ArrayList<>();
    }

    public Job(Long id, String name, String description, Company company) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.company = company;
        this.jobSkills = new ArrayList<>();
    }

    public Job() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }   

    public List<JobSkill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<JobSkill> jobSkills) {
        this.jobSkills = jobSkills;
    }
}
