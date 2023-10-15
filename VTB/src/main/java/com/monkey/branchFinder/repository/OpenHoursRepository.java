package com.monkey.branchFinder.repository;

import com.monkey.branchFinder.model.OpenHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpenHoursRepository extends JpaRepository<OpenHours, Long> {

    List<OpenHours> findByBranchId(Long branchId);

    @Query(value = "SELECT * FROM open_hours o " +
            "WHERE o.branch_id = :branchId " +
            "AND (" +
            "   (LENGTH(o.day) = 2 AND :dayOfWeekValue = o.day) " +
            "   OR (:dayOfWeekValue BETWEEN SUBSTRING(o.day, 1, 2) AND SUBSTRING(o.day, 4, 2))" +
            ") " +
            "AND :hourValue BETWEEN " +
            "CASE " +
            "    WHEN POSITION('-' IN o.hours) = 5 THEN CAST(SUBSTRING(o.hours, 1, 1) AS integer) " +
            "    ELSE CAST(SUBSTRING(o.hours, 1, 2) AS integer) " +
            "END " +
            "AND " +
            "CASE " +
            "    WHEN POSITION('-' IN o.hours) = 5 THEN CAST(SUBSTRING(o.hours, 6, 1) AS integer) " +
            "    ELSE CAST(SUBSTRING(o.hours, 7, 2) AS integer) " +
            "END " +
            "ORDER BY " +
            "CASE " +
            "    WHEN POSITION('-' IN o.hours) = 5 THEN CAST(SUBSTRING(o.hours, 1, 1) AS integer) " +
            "    ELSE CAST(SUBSTRING(o.hours, 1, 2) AS integer) " +
            "END DESC LIMIT 1", nativeQuery = true)
    List<OpenHours> findByBranchIdAndDayAndHour(Long branchId, String dayOfWeekValue, Integer hourValue);


}
