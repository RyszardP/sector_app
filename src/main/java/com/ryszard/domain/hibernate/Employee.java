package com.ryszard.domain.hibernate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {

    @NotNull(message = "Is required")
    @Size(min=1, message = "Is required")
    private String name;

    @NotNull(message = "Is required")
    @Size(min=1, message = "Is required")
    private String surname;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
