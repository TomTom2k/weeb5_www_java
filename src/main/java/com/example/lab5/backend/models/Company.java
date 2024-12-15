package com.example.lab5.backend.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Long id;

    private String name;
    private String about;
    private String phone;
    private String webURL;
    private String email;

    private String password;
    
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Company(String name, String about, String phone, String webURL, String email, Address address) {
        this.name = name;
        this.about = about;
        this.phone = phone;
        this.webURL = webURL;
        this.email = email;
        this.address = address;
        this.jobs = new ArrayList<>();
    }
    public Company(Long id, String name, String about, String phone, String webURL, String email, Address address) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.phone = phone;
        this.webURL = webURL;
        this.email = email;
        this.address = address;
        this.jobs = new ArrayList<>();
    }
    public Company() {
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }   

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }   

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }   

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }   

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
}
