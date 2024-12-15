package com.example.lab5.backend.repositories;

import com.example.lab5.backend.models.Job;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface JobRepository extends JpaRepository<Job, Long> {

    // @Query("SELECT j FROM Job j WHERE j.name LIKE %:search% OR j.description LIKE %:search%")
    // Page<Job> searchJobs(@Param("search") String search, Pageable pageable);

    // @EntityGraph(attributePaths = {"company"})
    // @Query("SELECT j FROM Job j WHERE j.id IN (:ids)")
    // List<Job> findJobsByIds(@Param("ids") List<Long> ids);

    // @EntityGraph(attributePaths = {"company"})
    // @Override
    // @NonNull
    // Page<Job> findAll(@NonNull Pageable pageable);
}
