package com.ryszard.domain.vo;

import java.util.Objects;

public class Sector {
    private Long sectorId;

    private String sectorName;

    private String sectorDepartmentId;

    public Sector() {
    }

    public Sector(Long sectorId, String sectorName, String sectorDepartmentId) {
        this.sectorId = sectorId;
        this.sectorName = sectorName;
        this.sectorDepartmentId = sectorDepartmentId;
    }

    public Long getSectorId() {
        return sectorId;
    }

    public void setSectorId(Long sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSectorDepartmentId() {
        return sectorDepartmentId;
    }

    public void setSectorDepartmentId(String sectorDepartmentId) {
        this.sectorDepartmentId = sectorDepartmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sector)) return false;
        Sector sector = (Sector) o;
        return Objects.equals(sectorId, sector.sectorId) &&
                Objects.equals(sectorName, sector.sectorName) &&
                Objects.equals(sectorDepartmentId, sector.sectorDepartmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectorId, sectorName, sectorDepartmentId);
    }

    @Override
    public String toString() {
        return "Sector{" +
                "sectorId=" + sectorId +
                ", sectorName='" + sectorName + '\'' +
                ", sectorDepartmentId='" + sectorDepartmentId + '\'' +
                '}';
    }
}
