package com.monkey.branchFinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "open_hours")
public class OpenHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "day")
    private String day;

    @Column(name = "hours")
    private String hours;

    @Column(name = "capacity")
    private Integer capacity;

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "OpenHours{" +
                "id=" + id +
                ", branchId=" + branchId +
                ", day='" + day + '\'' +
                ", hours='" + hours + '\'' +
                ", capacity=" + capacity +
                '}';
    }
    // Constructors, getters, setters, etc.
    // ... (similar to the BranchFunction example)
}
