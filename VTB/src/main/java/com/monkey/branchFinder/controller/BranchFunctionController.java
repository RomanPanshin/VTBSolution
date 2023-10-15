package com.monkey.branchFinder.controller;

import com.monkey.branchFinder.model.BranchFunction;
import com.monkey.branchFinder.service.BranchFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BranchFunctionController {

    @Autowired
    private BranchFunctionService branchFunctionService;

    @GetMapping("/branches/{branchId}/functions")
    public ResponseEntity<List<BranchFunction>> getFunctionsByBranchId(@PathVariable Long branchId) {
        List<BranchFunction> functions = branchFunctionService.getFunctionsByBranchId(branchId);
        if (functions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(functions);
    }
}
