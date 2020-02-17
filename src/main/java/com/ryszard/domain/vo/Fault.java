package com.ryszard.domain.vo;

import java.sql.Timestamp;
import java.util.Objects;

public class Fault {

    private Long faultId;

    private String type;

    private Timestamp faultDate;

    private Timestamp faultFinish;

    private Long faultSectorId;

    private Long faultBrigadeId;

    public Fault() {
    }

    public Fault(Long faultId, String type, Timestamp faultDate, Timestamp faultFinish, Long faultSectorId,
                 Long faultBrigadeId) {
        this.faultId = faultId;
        this.type = type;
        this.faultDate = faultDate;
        this.faultFinish = faultFinish;
        this.faultSectorId = faultSectorId;
        this.faultBrigadeId = faultBrigadeId;
    }

    public Long getFaultId() {
        return faultId;
    }

    public void setFaultId(Long faultId) {
        this.faultId = faultId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getFaultDate() {
        return faultDate;
    }

    public void setFaultDate(Timestamp faultDate) {
        this.faultDate = faultDate;
    }

    public Timestamp getFaultFinish() {
        return faultFinish;
    }

    public void setFaultFinish(Timestamp faultFinish) {
        this.faultFinish = faultFinish;
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
        return Objects.equals(faultId, fault.faultId) &&
                Objects.equals(type, fault.type) &&
                Objects.equals(faultDate, fault.faultDate) &&
                Objects.equals(faultFinish, fault.faultFinish) &&
                Objects.equals(faultSectorId, fault.faultSectorId) &&
                Objects.equals(faultBrigadeId, fault.faultBrigadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faultId, type, faultDate, faultFinish, faultSectorId, faultBrigadeId);
    }

    @Override
    public String toString() {
        return "Fault{" +
                "faultId=" + faultId +
                ", type='" + type + '\'' +
                ", faultDate=" + faultDate +
                ", faultFinish=" + faultFinish +
                ", faultSectorId=" + faultSectorId +
                ", faultBrigadeId=" + faultBrigadeId +
                '}';
    }
}
