package com.example.lab5.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab5.backend.models.Address;
import com.example.lab5.backend.repositories.AddressRepository;

@Service
public class AddressService implements IService<Address> {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address entity) {
        return addressRepository.save(entity);
    }
    
    @Override
    public Address update(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Address delete(Address entity) {
        addressRepository.delete(entity);
        return entity;
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findByCompanyId(Long companyId) {
        return addressRepository.findByCompanyId(companyId);
    }

    public Address findByCandidateId(Long candidateId) {
        return addressRepository.findByCandidateId(candidateId);
    }

    public List<Address> findLatestAddress() {
        return addressRepository.findLatestAddress();
    }
}
