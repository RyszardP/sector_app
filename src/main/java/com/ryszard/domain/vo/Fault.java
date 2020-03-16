package com.ryszard.domain.vo;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Fault {

    private int faultId;

    private String faultType;

    private Date faultDate;

    private Date faultFinish;

    private int faultSectorId;

    private int faultBrigadeId;

    public Fault() {
    }

    public Fault(int faultId, String faultType, Date faultDate, Date faultFinish, int faultSectorId, int faultBrigadeId) {
        this.faultId = faultId;
        this.faultType = faultType;
        this.faultDate = faultDate;
        this.faultFinish = faultFinish;
        this.faultSectorId = faultSectorId;
        this.faultBrigadeId = faultBrigadeId;
    }

    public Fault(String faultType, Date faultDate, Date faultFinish, int faultSectorId, int faultBrigadeId) {
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

    public String getFaultDate() {
        String str = "";
        if (this.faultDate != null) {
            str = new SimpleDateFormat("yyyy-MM-dd").format(this.faultDate);
        }
        return str;
    }

    public void setFaultDate(String faultDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date formatDate = null;
        try {
            formatDate = sdf.parse(faultDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.faultDate = formatDate;
    }

    public String getFaultFinish() {
        String str = "";
        if (this.faultFinish != null) {
            str = new SimpleDateFormat("yyyy-MM-dd").format(this.faultFinish);
        }
        return str;
    }

    public void setFaultFinish(String faultFinish) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date formatDate = null;
        try {
            formatDate = sdf.parse(faultFinish);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.faultFinish = formatDate;
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
