package com.example.lab5.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;

    private String city;
    private String country;
    private String zipcode;
    private String street;
    private String number;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Address(String city, String country, String zipcode, String street, String number) {
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
        this.street = street;
        this.number = number;
    }

    public Address(Long id, String city, String country, String zipcode, String street, String number, Candidate candidate, Company company) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
        this.street = street;
        this.number = number;
        this.candidate = candidate;
        this.company = company;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }           

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }   

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }   

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }   

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
