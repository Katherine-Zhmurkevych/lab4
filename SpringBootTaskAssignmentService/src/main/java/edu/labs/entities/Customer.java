package edu.labs.entities;

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private Company company;

    public Customer(final Long id, final String firstName, final String lastName, final Company company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(final Company company) {
        this.company = company;
    }
}
