package edu.labs.entities;

public class Company {
    private Long id;
    private String companyName;
    private String country;

    public Company(final Long id, final String companyName, final String country) {
        this.id = id;
        this.companyName = companyName;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }
}
