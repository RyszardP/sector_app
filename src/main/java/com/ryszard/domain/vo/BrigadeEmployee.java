package com.ryszard.domain.vo;

import java.sql.Timestamp;
import java.util.Objects;

public class BrigadeEmployee {

    private Long brigadeEmployeeId;

    private Long employeeId;

    private Long brigadeId;

    private Timestamp start;

    private Timestamp finish;

    public BrigadeEmployee() {
    }

    public BrigadeEmployee(Long brigadeEmployeeId, Long employeeId, Long brigadeId, Timestamp start, Timestamp finish) {
        this.brigadeEmployeeId = brigadeEmployeeId;
        this.employeeId = employeeId;
        this.brigadeId = brigadeId;
        this.start = start;
        this.finish = finish;
    }

    public Long getBrigadeEmployeeId() {
        return brigadeEmployeeId;
    }

    public void setBrigadeEmployeeId(Long brigadeEmployeeId) {
        this.brigadeEmployeeId = brigadeEmployeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getBrigadeId() {
        return brigadeId;
    }

    public void setBrigadeId(Long brigadeId) {
        this.brigadeId = brigadeId;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getFinish() {
        return finish;
    }

    public void setFinish(Timestamp finish) {
        this.finish = finish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrigadeEmployee)) return false;
        BrigadeEmployee that = (BrigadeEmployee) o;
        return Objects.equals(brigadeEmployeeId, that.brigadeEmployeeId) &&
                Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(brigadeId, that.brigadeId) &&
                Objects.equals(start, that.start) &&
                Objects.equals(finish, that.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brigadeEmployeeId, employeeId, brigadeId, start, finish);
    }

    @Override
    public String toString() {
        return "BrigadeEmployee{" +
                "brigadeEmployeeId=" + brigadeEmployeeId +
                ", employeeId=" + employeeId +
                ", brigadeId=" + brigadeId +
                ", start=" + start +
                ", finish=" + finish +
                '}';
    }
}
