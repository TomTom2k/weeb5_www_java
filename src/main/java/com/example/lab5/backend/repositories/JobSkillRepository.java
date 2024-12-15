package com.example.lab5.backend.repositories;

import com.example.lab5.backend.models.JobSkill;
import com.example.lab5.backend.pks.JobSkillPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillPk> {
}
