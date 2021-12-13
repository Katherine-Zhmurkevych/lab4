package edu.labs.converters;


import org.springframework.stereotype.Component;

import edu.labs.dto.CompanyDTO;
import edu.labs.entities.Company;

@Component
public class CompanyConverter implements EntityConverter<Company, CompanyDTO> {

    @Override
    public Company toEntity(final CompanyDTO dto) {
        return new Company(dto.getId(), dto.getCompanyName(), dto.getCountry());
    }

    @Override
    public CompanyDTO toDto(final Company item) {
        return new CompanyDTO(item.getId(), item.getCompanyName(), item.getCountry());
    }
}
