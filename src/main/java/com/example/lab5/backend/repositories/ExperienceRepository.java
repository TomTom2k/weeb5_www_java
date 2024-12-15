package com.example.lab5.backend.repositories;

import com.example.lab5.backend.models.Experience;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
