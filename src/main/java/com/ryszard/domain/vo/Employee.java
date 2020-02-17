package com.ryszard.domain.vo;

import java.util.Objects;

public class Employee {
    private Long employeeId;

    private Long employeeSectorId;

    private String employeePosition;

    public Employee() {
    }

    public Employee(Long employeeId, Long employeeSectorId, String employeePosition) {
        this.employeeId = employeeId;
        this.employeeSectorId = employeeSectorId;
        this.employeePosition = employeePosition;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeSectorId() {
        return employeeSectorId;
    }

    public void setEmployeeSectorId(Long employeeSectorId) {
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
        return Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(employeeSectorId, employee.employeeSectorId) &&
                Objects.equals(employeePosition, employee.employeePosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeSectorId, employeePosition);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeSectorId=" + employeeSectorId +
                ", employeePosition='" + employeePosition + '\'' +
                '}';
    }
}
