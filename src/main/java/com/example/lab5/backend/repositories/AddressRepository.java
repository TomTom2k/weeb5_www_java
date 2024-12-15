package com.example.lab5.backend.repositories;

import com.example.lab5.backend.models.Address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository  extends JpaRepository<Address, Long> {
    Address findByCompanyId(Long companyId);
    Address findByCandidateId(Long candidateId);

    @Query("SELECT a FROM Address a ORDER BY a.id DESC LIMIT 1")
    List<Address> findLatestAddress();
}
