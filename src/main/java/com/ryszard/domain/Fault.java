package com.ryszard.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="fault")
public class Fault {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="fault_id")
    private Long faultId;

    @Column(name="fault_type")
    private String faultType;

    @Column(name="fault_date")
    private Timestamp faultDate;

    @Column(name="fault_finish")
    private Timestamp faultFinishDate;

    @Column(name="fault_sector_id")
    private Long faultSectorId;

    @Column(name="fault_brigade_id")
    private Long faultBrigadeId;

    public Fault() {
    }

    public Fault(Long faultId, String faultType, Timestamp faultDate, Timestamp faultFinishDate, Long faultSectorId, Long faultBrigadeId) {
        this.faultId = faultId;
        this.faultType = faultType;
        this.faultDate = faultDate;
        this.faultFinishDate = faultFinishDate;
        this.faultSectorId = faultSectorId;
        this.faultBrigadeId = faultBrigadeId;
    }

    public Long getFaultId() {
        return faultId;
    }

    public void setFaultId(Long faultId) {
        this.faultId = faultId;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public Timestamp getFaultDate() {
        return faultDate;
    }

    public void setFaultDate(Timestamp faultDate) {
        this.faultDate = faultDate;
    }

    public Timestamp getFaultFinishDate() {
        return faultFinishDate;
    }

    public void setFaultFinishDate(Timestamp faultFinishDate) {
        this.faultFinishDate = faultFinishDate;
    }

    public Long getFaultSectorId() {
        return faultSectorId;
    }

    public void setFaultSectorId(Long faultSectorId) {
        this.faultSectorId = faultSectorId;
    }

    public Long getFaultBrigadeId() {
        return faultBrigadeId;
    }

    public void setFaultBrigadeId(Long faultBrigadeId) {
        this.faultBrigadeId = faultBrigadeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fault)) return false;

        Fault fault = (Fault) o;

        if (getFaultId() != null ? !getFaultId().equals(fault.getFaultId()) : fault.getFaultId() != null) return false;
        if (getFaultType() != null ? !getFaultType().equals(fault.getFaultType()) : fault.getFaultType() != null)
            return false;
        if (getFaultDate() != null ? !getFaultDate().equals(fault.getFaultDate()) : fault.getFaultDate() != null)
            return false;
        if (getFaultFinishDate() != null ? !getFaultFinishDate().equals(fault.getFaultFinishDate()) : fault.getFaultFinishDate() != null)
            return false;
        if (getFaultSectorId() != null ? !getFaultSectorId().equals(fault.getFaultSectorId()) : fault.getFaultSectorId() != null)
            return false;
        return getFaultBrigadeId() != null ? getFaultBrigadeId().equals(fault.getFaultBrigadeId()) : fault.getFaultBrigadeId() == null;
    }

    @Override
    public int hashCode() {
        int result = getFaultId() != null ? getFaultId().hashCode() : 0;
        result = 31 * result + (getFaultType() != null ? getFaultType().hashCode() : 0);
        result = 31 * result + (getFaultDate() != null ? getFaultDate().hashCode() : 0);
        result = 31 * result + (getFaultFinishDate() != null ? getFaultFinishDate().hashCode() : 0);
        result = 31 * result + (getFaultSectorId() != null ? getFaultSectorId().hashCode() : 0);
        result = 31 * result + (getFaultBrigadeId() != null ? getFaultBrigadeId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fault{");
        sb.append("faultId=").append(faultId);
        sb.append(", faultType='").append(faultType).append('\'');
        sb.append(", faultDate=").append(faultDate);
        sb.append(", faultFinishDate=").append(faultFinishDate);
        sb.append(", faultSectorId=").append(faultSectorId);
        sb.append(", faultBrigadeId=").append(faultBrigadeId);
        sb.append('}');
        return sb.toString();
    }




}