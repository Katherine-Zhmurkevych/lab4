package edu.labs.dto;

import edu.labs.enums.EmployeeLevel;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class EmployeeDTO {

    private long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private EmployeeLevel level;
    private Date birthDay;

    public EmployeeDTO(final long id, final String firstName, final String lastName, final EmployeeLevel level, final Date birthDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.birthDay = birthDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public EmployeeLevel getLevel() {
        return level;
    }

    public void setLevel(EmployeeLevel level) {
        this.level = level;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
