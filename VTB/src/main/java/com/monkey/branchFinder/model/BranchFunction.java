package com.monkey.branchFinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "functions")
public class BranchFunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "function_name")
    private String functionName;

    public BranchFunction() {}

    public BranchFunction(Long branchId, String functionName) {
        this.branchId = branchId;
        this.functionName = functionName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @Override
    public String toString() {
        return "BranchFunction{" +
                "id=" + id +
                ", branchId=" + branchId +
                ", functionName='" + functionName + '\'' +
                '}';
    }
}
