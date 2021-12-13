package edu.labs.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import edu.labs.converters.CompanyConverter;
import edu.labs.dto.CompanyDTO;
import edu.labs.entities.Company;
import edu.labs.exceptions.CompanyNotFoundException;
import edu.labs.repositories.CompanyRepository;
import edu.labs.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyRepository companyRepository;
    @Resource
    private CompanyConverter companyConverter;

    @Override
    public List<CompanyDTO> getAllCompanies() {
        final List<Company> allCompanies = companyRepository.getAll();
        return allCompanies.stream().map(item -> companyConverter.toDto(item)).collect(Collectors.toList());
    }

    @Override
    public CompanyDTO getCompanyById(final Long id) throws CompanyNotFoundException {
        return companyConverter.toDto(companyRepository.getById(id));
    }

    @Override
    public CompanyDTO updateCompany(final CompanyDTO dto) throws CompanyNotFoundException {
        Assert.isNull(dto, "Company dto is null");

        final Company updatedCompany = companyRepository.update(companyConverter.toEntity(dto));
        return companyConverter.toDto(updatedCompany);
    }

    @Override
    public void removeCompany(CompanyDTO dto) {
        final Company companyToRemove = companyConverter.toEntity(dto);
        companyRepository.remove(companyToRemove);
    }

    @Override
    public Long createCompany(final CompanyDTO dto) {
        final Company companyToCreate = companyConverter.toEntity(dto);
        companyRepository.create(companyToCreate);
        return companyToCreate.getId();
    }

    @Override
    public void removeCompanyById(final Long id) throws CompanyNotFoundException {
        final CompanyDTO companyToRemove = getCompanyById(id);
        removeCompany(companyToRemove);
    }
}
