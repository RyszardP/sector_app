package com.ryszard.domain.vo;

import java.sql.Timestamp;
import java.util.Objects;

public class BrigadeEmployee {

    private int brigadeEmployeeId;

    private int employeeId;

    private int brigadeId;

    private Timestamp start;

    private Timestamp finish;

    public BrigadeEmployee() {
    }

    public BrigadeEmployee(int brigadeEmployeeId, int employeeId, int brigadeId, Timestamp start, Timestamp finish) {
        this.brigadeEmployeeId = brigadeEmployeeId;
        this.employeeId = employeeId;
        this.brigadeId = brigadeId;
        this.start = start;
        this.finish = finish;
    }

    public void setBrigadeEmployeeId(int brigadeEmployeeId) {
        this.brigadeEmployeeId = brigadeEmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setBrigadeId(int brigadeId) {
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
