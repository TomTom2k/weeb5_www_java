package com.example.lab5.backend.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "experience_id")
    private Long id;

    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "company_name")
    private String companyName;
    private String role;
    @Column(name = "work_description")
    private String workDescription;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


    @Override
    public String toString() {
        return "Experience [id=" + id + ", toDate=" + toDate + ", fromDate=" + fromDate + ", companyName=" + companyName
                + ", role=" + role + ", workDescription=" + workDescription + ", candidate=" + candidate + "]";
    }

    public Experience(LocalDate toDate, LocalDate fromDate, String companyName, String role, String workDescription, Candidate candidate) {
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.companyName = companyName;
        this.role = role;
        this.workDescription = workDescription;
        this.candidate = candidate;
    }   

    public Experience(Long id, LocalDate toDate, LocalDate fromDate, String companyName, String role, String workDescription, Candidate candidate) {
        this.id = id;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.companyName = companyName;
        this.role = role;
        this.workDescription = workDescription;
        this.candidate = candidate;
    }
    
    public Experience() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }       

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }   

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }   

    public String getRole() {
        return role;
    }   

    public void setRole(String role) {
        this.role = role;
    }   

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }           
}
