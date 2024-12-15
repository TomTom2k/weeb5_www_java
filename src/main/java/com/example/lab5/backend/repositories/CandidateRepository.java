package com.example.lab5.backend.repositories;

import com.example.lab5.backend.models.Candidate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findByEmail(String email);

    // @Query("SELECT c FROM Candidate c LEFT JOIN Address a ON c.id = a.candidate WHERE c.id = :id")
    // Optional<Candidate> findByIdWithAddress(@Param("id") Long id);

    // @Query("SELECT c FROM Candidate c LEFT JOIN CandidateSkill cs ON c.id = cs.candidate WHERE c.id = :id")
    // List<Candidate> findCandidatesById(@Param("id") Long id);
}
