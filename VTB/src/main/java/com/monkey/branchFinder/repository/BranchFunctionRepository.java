package com.monkey.branchFinder.repository;

import com.monkey.branchFinder.model.BranchFunction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchFunctionRepository extends JpaRepository<BranchFunction, Long> {
    List<BranchFunction> findByBranchId(Long branchId);
}
