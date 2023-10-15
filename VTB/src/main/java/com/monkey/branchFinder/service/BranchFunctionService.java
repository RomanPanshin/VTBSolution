package com.monkey.branchFinder.service;

import com.monkey.branchFinder.model.BranchFunction;
import com.monkey.branchFinder.repository.BranchFunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchFunctionService {

    @Autowired
    private BranchFunctionRepository branchFunctionRepository;

    public List<BranchFunction> getFunctionsByBranchId(Long branchId) {
        return branchFunctionRepository.findByBranchId(branchId);
    }
}
