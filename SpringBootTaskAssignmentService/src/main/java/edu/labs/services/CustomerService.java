package edu.labs.services;

import java.util.List;

import edu.labs.dto.CustomerDTO;
import edu.labs.exceptions.BaseException;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(final Long id) throws BaseException;

    CustomerDTO updateCustomer(CustomerDTO dto) throws BaseException;

    void removeCustomer(CustomerDTO dto);

    Long createCustomer(CustomerDTO dto);

    void removeCustomerById(Long id) throws BaseException;
}
