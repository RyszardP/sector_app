package com.ryszard.domain.vo;

import java.sql.Timestamp;
import java.util.Objects;

public class Fault {

    private int faultId;

    private String faultType;

    private Timestamp faultDate;

    private Timestamp faultFinish;

    private int faultSectorId;

    private int faultBrigadeId;

    public Fault() {
    }

    public Fault(int faultId, String type, Timestamp faultDate, Timestamp faultFinish, int faultSectorId, int faultBrigadeId) {
        this.faultId = faultId;
        this.faultType = faultType;
        this.faultDate = faultDate;
        this.faultFinish = faultFinish;
        this.faultSectorId = faultSectorId;
        this.faultBrigadeId = faultBrigadeId;
    }

    public Fault(String faultType, Timestamp faultDate, Timestamp faultFinish, int faultSectorId, int faultBrigadeId) {
        this.faultType = faultType;
        this.faultDate = faultDate;
        this.faultFinish = faultFinish;
        this.faultSectorId = faultSectorId;
        this.faultBrigadeId = faultBrigadeId;
    }

    public int getFaultId() {
        return faultId;
    }

    public void setFaultId(int faultId) {
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

    public Timestamp getFaultFinish() {
        return faultFinish;
    }

    public void setFaultFinish(Timestamp faultFinish) {
        this.faultFinish = faultFinish;
    }

    public int getFaultSectorId() {
        return faultSectorId;
    }

    public void setFaultSectorId(int faultSectorId) {
        this.faultSectorId = faultSectorId;
    }

    public int getFaultBrigadeId() {
        return faultBrigadeId;
    }

    public void setFaultBrigadeId(int faultBrigadeId) {
        this.faultBrigadeId = faultBrigadeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fault)) return false;
        Fault fault = (Fault) o;
        return faultId == fault.faultId &&
                faultSectorId == fault.faultSectorId &&
                faultBrigadeId == fault.faultBrigadeId &&
                Objects.equals(faultType, fault.faultType) &&
                Objects.equals(faultDate, fault.faultDate) &&
                Objects.equals(faultFinish, fault.faultFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faultId, faultType, faultDate, faultFinish, faultSectorId, faultBrigadeId);
    }

    @Override
    public String toString() {
        return "Fault{" +
                "faultId=" + faultId +
                ", faultType='" + faultType + '\'' +
                ", faultDate=" + faultDate +
                ", faultFinish=" + faultFinish +
                ", faultSectorId=" + faultSectorId +
                ", faultBrigadeId=" + faultBrigadeId +
                '}';
    }
}
