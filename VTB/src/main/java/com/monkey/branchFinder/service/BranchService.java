package com.monkey.branchFinder.service;

import com.monkey.branchFinder.model.Branch;
import com.monkey.branchFinder.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    // Retrieve all branches
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    // Retrieve a branch by its ID
    public Branch getBranchById(Long id) {
        return branchRepository.findById(id).orElse(null);
    }

    // Create a new branch
    public Branch createBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    // Update a branch by its ID
    public Branch updateBranch(Long id, Branch branchDetails) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if (optionalBranch.isPresent()) {
            Branch branchToUpdate = optionalBranch.get();
            branchToUpdate.setSalePointName(branchDetails.getSalePointName());
            branchToUpdate.setAddress(branchDetails.getAddress());
            branchToUpdate.setStatus(branchDetails.getStatus());
            branchToUpdate.setRko(branchDetails.getRko());
            branchToUpdate.setOfficeType(branchDetails.getOfficeType());
            branchToUpdate.setSalePointFormat(branchDetails.getSalePointFormat());
            branchToUpdate.setSuoAvailability(branchDetails.getSuoAvailability());
            branchToUpdate.setHasRamp(branchDetails.getHasRamp());
            branchToUpdate.setLatitude(branchDetails.getLatitude());
            branchToUpdate.setLongitude(branchDetails.getLongitude());
            branchToUpdate.setMetroStation(branchDetails.getMetroStation());
            branchToUpdate.setDistance(branchDetails.getDistance());
            branchToUpdate.setKep(branchDetails.getKep());
            branchToUpdate.setMyBranch(branchDetails.getMyBranch());
            return branchRepository.save(branchToUpdate);
        } else {
            return null;
        }
    }

    // Delete a branch by its ID
    public boolean deleteBranch(Long id) {
        if (branchRepository.existsById(id)) {
            branchRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public List<Branch> getNearbyBranches(Double latitude, Double longitude) {
        return branchRepository.findNearbyBranches(latitude, longitude);
    }
}