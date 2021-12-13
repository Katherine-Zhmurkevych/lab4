package edu.labs.dto;

import javax.validation.constraints.NotBlank;

import edu.labs.entities.Company;

public class CustomerDTO {

    private long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private Company company;

    public CustomerDTO(final long id, final String firstName, final String lastName, final Company company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
