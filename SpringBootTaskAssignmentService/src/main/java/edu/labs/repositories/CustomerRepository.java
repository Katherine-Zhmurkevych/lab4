package edu.labs.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.labs.entities.Customer;
import edu.labs.exceptions.CustomerNotFoundException;

@Repository
public class CustomerRepository implements CrudRepository<Customer> {
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public Customer getById(final Long id) throws CustomerNotFoundException {
        return customers.stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElseThrow(() -> new CustomerNotFoundException(400, id + " Customer not found"));
    }

    @Override
    public Customer update(final Customer customer) throws CustomerNotFoundException {
        final Customer customerToUpdate = getById(customer.getId());
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setCompany(customer.getCompany());

        return customerToUpdate;
    }

    @Override
    public void remove(final Customer customer) {
        customers.remove(customer);
    }

    @Override
    public Long create(final Customer item) {
        customers.add(item);
        return item.getId();
    }
}
