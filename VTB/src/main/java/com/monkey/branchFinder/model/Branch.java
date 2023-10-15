package com.monkey.branchFinder.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salepointname")
    private String salePointName;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private String status;

    @Column(name = "rko")
    private String rko;

    @Column(name = "officetype")
    private String officeType;

    @Column(name = "salepointformat")
    private String salePointFormat;

    @Column(name = "suoavailability")
    private Boolean suoAvailability;

    @Column(name = "hasramp")
    private Boolean hasRamp;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "metrostation")
    private String metroStation;

    @Column(name = "distance")
    private String distance;

    @Column(name = "kep")
    private String kep;

    @Column(name = "mybranch")
    private String myBranch;

    public Branch() {}

    public Branch(String salePointName, String address, String status, String rko, String officeType,
                  String salePointFormat, Boolean suoAvailability, Boolean hasRamp, Double latitude,
                  Double longitude, String metroStation, String distance, String kep, String myBranch) {
        this.salePointName = salePointName;
        this.address = address;
        this.status = status;
        this.rko = rko;
        this.officeType = officeType;
        this.salePointFormat = salePointFormat;
        this.suoAvailability = suoAvailability;
        this.hasRamp = hasRamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.metroStation = metroStation;
        this.distance = distance;
        this.kep = kep;
        this.myBranch = myBranch;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalePointName() {
        return salePointName;
    }

    public void setSalePointName(String salePointName) {
        this.salePointName = salePointName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRko() {
        return rko;
    }

    public void setRko(String rko) {
        this.rko = rko;
    }

    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }

    public String getSalePointFormat() {
        return salePointFormat;
    }

    public void setSalePointFormat(String salePointFormat) {
        this.salePointFormat = salePointFormat;
    }

    public Boolean getSuoAvailability() {
        return suoAvailability;
    }

    public void setSuoAvailability(Boolean suoAvailability) {
        this.suoAvailability = suoAvailability;
    }

    public Boolean getHasRamp() {
        return hasRamp;
    }

    public void setHasRamp(Boolean hasRamp) {
        this.hasRamp = hasRamp;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getKep() {
        return kep;
    }

    public void setKep(String kep) {
        this.kep = kep;
    }

    public String getMyBranch() {
        return myBranch;
    }

    public void setMyBranch(String myBranch) {
        this.myBranch = myBranch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(id, branch.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", salePointName='" + salePointName + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", rko='" + rko + '\'' +
                ", officeType='" + officeType + '\'' +
                ", salePointFormat='" + salePointFormat + '\'' +
                ", suoAvailability=" + suoAvailability +
                ", hasRamp=" + hasRamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", metroStation='" + metroStation + '\'' +
                ", distance='" + distance + '\'' +
                ", kep='" + kep + '\'' +
                ", myBranch='" + myBranch + '\'' +
                '}';
    }
}
