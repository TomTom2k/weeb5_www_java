package com.example.lab5.backend.repositories;

import com.example.lab5.backend.models.CandidateSkill;
import com.example.lab5.backend.pks.CandidateSkillPk;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
    

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillPk> {
    // @Query("SELECT cs.skillId FROM CandidateSkill cs WHERE cs.candidateId = :candidateId")
    // List<Long> findSkillIdsByCandidateId(@Param("candidateId") Long candidateId);
}
