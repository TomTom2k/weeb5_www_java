package com.example.lab5.backend.repositories;

import com.example.lab5.backend.models.Company;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByEmail(String email);

    // @Query("SELECT c FROM Company c LEFT JOIN Address a ON c.id = a.companyId WHERE c.id = :id")
    // Optional<Company> findByIdWithAddress(@Param("id") Long id);

    // @Query("SELECT c FROM Company c LEFT JOIN CompanySkill cs ON c.id = cs.companyId WHERE c.id = :id")
    // List<Company> findCompaniesById(@Param("id") Long id);
}
