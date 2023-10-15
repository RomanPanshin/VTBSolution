package com.monkey.branchFinder.repository;
import com.monkey.branchFinder.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    // Example custom query methods:

    // Find branches by sale point name
    List<Branch> findBySalePointName(String salePointName);

    // Find branches by office type
    List<Branch> findByOfficeType(String officeType);

    // Find branches by status
    List<Branch> findByStatus(String status);
    @Query("SELECT b FROM Branch b WHERE " +
            "6371 * acos(cos(radians(?1)) * cos(radians(b.latitude)) " +
            "* cos(radians(b.longitude) - radians(?2)) + sin(radians(?1)) " +
            "* sin(radians(b.latitude))) < 15") // Here 10 is the radius in km
    List<Branch> findNearbyBranches(Double latitude, Double longitude);
}