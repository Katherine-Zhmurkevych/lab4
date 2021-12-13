package edu.labs.services;

import java.util.List;

import edu.labs.dto.CompanyDTO;
import edu.labs.exceptions.BaseException;

public interface CompanyService {

    List<CompanyDTO> getAllCompanies();

    CompanyDTO getCompanyById(final Long id) throws BaseException;

    CompanyDTO updateCompany(CompanyDTO dto) throws BaseException;

    void removeCompany(CompanyDTO dto);

    Long createCompany(CompanyDTO dto);

    void removeCompanyById(Long id) throws BaseException;
}
