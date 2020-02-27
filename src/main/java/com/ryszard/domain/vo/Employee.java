package com.ryszard.domain.vo;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private int employeeId;

    private int employeeSectorId;

    private String employeePosition;

    public Employee() {

    }

    public Employee(int employeeId, int employeeSectorId, String employeePosition) {
        this.employeeId = employeeId;
        this.employeeSectorId = employeeSectorId;
        this.employeePosition = employeePosition;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeSectorId() {
        return employeeSectorId;
    }

    public void setEmployeeSectorId(int employeeSectorId) {
        this.employeeSectorId = employeeSectorId;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                employeeSectorId == employee.employeeSectorId &&
                Objects.equals(employeePosition, employee.employeePosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeSectorId, employeePosition);
    }
}
