package com.monkey.branchFinder.service;

import com.monkey.branchFinder.model.Atm;
import com.monkey.branchFinder.repository.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtmService {

    private final AtmRepository atmRepository;

    @Autowired
    public AtmService(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    public Optional<Atm> findById(Long id) {
        return atmRepository.findById(id);
    }
    public List<Atm> findNearbyAtms(Double latitude, Double longitude) {
        return atmRepository.findNearbyAtms(latitude, longitude);
    }
}