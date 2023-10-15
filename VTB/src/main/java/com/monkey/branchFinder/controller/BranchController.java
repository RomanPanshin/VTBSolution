package com.monkey.branchFinder.controller;

import com.monkey.branchFinder.model.Branch;
import com.monkey.branchFinder.model.OpenHours;
import com.monkey.branchFinder.service.BranchService;
import com.monkey.branchFinder.service.OpenHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;


    // Retrieve all branches
    @GetMapping
    public List<Branch> getAllBranches() {
        return branchService.getAllBranches();
    }

    // Retrieve a branch by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Branch> getBranchById(@PathVariable Long id) {
        Branch branch = branchService.getBranchById(id);
        if (branch != null) {
            return ResponseEntity.ok(branch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new branch
    @PostMapping
    public Branch createBranch(@RequestBody Branch branch) {
        return branchService.createBranch(branch);
    }

    // Update a branch by its ID
    @PutMapping("/{id}")
    public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @RequestBody Branch branchDetails) {
        Branch updatedBranch = branchService.updateBranch(id, branchDetails);
        if (updatedBranch != null) {
            return ResponseEntity.ok(updatedBranch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a branch by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable Long id) {
        if (branchService.deleteBranch(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/branches/nearby")
    public ResponseEntity<List<Branch>> getNearbyBranches(
            @RequestParam Double latitude,
            @RequestParam Double longitude) {

        List<Branch> nearbyBranches = branchService.getNearbyBranches(latitude, longitude);

        if (nearbyBranches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(nearbyBranches);
    }
}
