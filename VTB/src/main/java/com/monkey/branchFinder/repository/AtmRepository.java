package com.monkey.branchFinder.repository;

import com.monkey.branchFinder.model.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends JpaRepository<Atm, Long> {
        @Query("SELECT a FROM Atm a WHERE " +
                "6371 * acos(cos(radians(?1)) * cos(radians(a.latitude)) " +
                "* cos(radians(a.longitude) - radians(?2)) + sin(radians(?1)) " +
                "* sin(radians(a.latitude))) < 3") // Here 100 is the radius in km
        List<Atm> findNearbyAtms(Double latitude, Double longitude);


}

