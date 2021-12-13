package edu.labs.entities;

import java.util.Date;

import edu.labs.enums.EmployeeLevel;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private EmployeeLevel level;
    private Date birthDay;

    public Employee() {
    }

    public Employee(final Long id, final String firstName, final String lastName, final EmployeeLevel level,
            final Date birthDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.birthDay = birthDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public EmployeeLevel getLevel() {
        return level;
    }

    public void setLevel(final EmployeeLevel level) {
        this.level = level;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(final Date birthDay) {
        this.birthDay = birthDay;
    }
}
