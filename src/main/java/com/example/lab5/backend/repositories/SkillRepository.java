package com.example.lab5.backend.repositories;

import com.example.lab5.backend.models.Skill;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    boolean existsBySkillName(String skillName);
}
