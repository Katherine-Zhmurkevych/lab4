package edu.labs.converters;

import edu.labs.dto.CustomerDTO;
import edu.labs.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter implements EntityConverter<Customer, CustomerDTO> {

    @Override
    public Customer toEntity(final CustomerDTO dto) {
        return new Customer(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getCompany());
    }

    @Override
    public CustomerDTO toDto(final Customer item) {
        return new CustomerDTO(item.getId(), item.getFirstName(), item.getLastName(), item.getCompany());
    }
}
