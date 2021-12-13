package edu.labs.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.labs.entities.Company;
import edu.labs.exceptions.CompanyNotFoundException;

@Repository
public class CompanyRepository implements CrudRepository<Company> {
    
    private final List<Company> companies = new ArrayList<>();

    @Override
    public List<Company> getAll() {
        return companies;
    }

    @Override
    public Company getById(final Long id) throws CompanyNotFoundException {
        return companies.stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElseThrow(() -> new CompanyNotFoundException(400, id + " Company not found"));
    }

    @Override
    public Company update(final Company company) throws CompanyNotFoundException {
        final Company companyToUpdate = getById(company.getId());
        companyToUpdate.setCompanyName(company.getCompanyName());
        companyToUpdate.setCountry(company.getCountry());
        return companyToUpdate;
    }

    @Override
    public void remove(final Company company) {
        companies.remove(company);
    }

    @Override
    public Long create(final Company item) {
        companies.add(item);
        return item.getId();
    }
}
