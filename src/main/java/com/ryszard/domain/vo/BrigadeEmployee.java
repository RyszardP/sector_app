package com.ryszard.domain.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class BrigadeEmployee {

    private int brigadeEmployeeId;

    private int employeeId;

    private int brigadeId;

    private Date start;

    private Date finish;

    public BrigadeEmployee() {
    }

    public BrigadeEmployee(int brigadeEmployeeId, int employeeId, int brigadeId, Date start, Date finish) {
        this.brigadeEmployeeId = brigadeEmployeeId;
        this.employeeId = employeeId;
        this.brigadeId = brigadeId;
        this.start = start;
        this.finish = finish;
    }

    public BrigadeEmployee(int employeeId, int brigadeId, Date start, Date finish) {
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

    public String getStart() {
        String str = "";
        if (this.start != null) {
            str = new SimpleDateFormat("yyyy-MM-dd").format(this.start);
        }
        return str;
    }

    public void setStart(String start) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date formatDate = null;
        try {
            formatDate = sdf.parse(start);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.start = formatDate;
    }

    public String getFinish() {
        String str = "";
        if (this.finish != null) {
            str = new SimpleDateFormat("yyyy-MM-dd").format(this.finish);
        }
        return str;
    }

    public void setFinish(String finish) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date formatDate = null;
        try {
            formatDate = sdf.parse(finish);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.finish = formatDate;
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
