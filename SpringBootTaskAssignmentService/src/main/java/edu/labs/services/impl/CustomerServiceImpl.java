package edu.labs.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import edu.labs.converters.CustomerConverter;
import edu.labs.dto.CustomerDTO;
import edu.labs.entities.Customer;
import edu.labs.exceptions.CustomerNotFoundException;
import edu.labs.repositories.CustomerRepository;
import edu.labs.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerRepository customerRepository;
    @Resource
    private CustomerConverter customerConverter;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        final List<Customer> allTasks = customerRepository.getAll();
        return allTasks.stream().map(item -> customerConverter.toDto(item)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(final Long id) throws CustomerNotFoundException {
        return customerConverter.toDto(customerRepository.getById(id));
    }

    @Override
    public CustomerDTO updateCustomer(final CustomerDTO dto) throws CustomerNotFoundException {
        Assert.isNull(dto, "Customer dto is null");

        final Customer updatedTask = customerRepository.update(customerConverter.toEntity(dto));
        return customerConverter.toDto(updatedTask);
    }

    @Override
    public void removeCustomer(CustomerDTO dto) {
        final Customer customerToRemove = customerConverter.toEntity(dto);
        customerRepository.remove(customerToRemove);
    }

    @Override
    public Long createCustomer(final CustomerDTO dto) {
        final Customer customerToCreate = customerConverter.toEntity(dto);
        customerRepository.create(customerToCreate);
        return customerToCreate.getId();
    }

    @Override
    public void removeCustomerById(final Long id) throws CustomerNotFoundException {
        final CustomerDTO customerToRemove = getCustomerById(id);
        removeCustomer(customerToRemove);
    }
}
