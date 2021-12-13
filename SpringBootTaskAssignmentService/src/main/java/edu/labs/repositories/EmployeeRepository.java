package edu.labs.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.labs.entities.Employee;
import edu.labs.exceptions.EmployeeNotFoundException;

@Repository
public class EmployeeRepository implements CrudRepository<Employee> {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee getById(final Long id) throws EmployeeNotFoundException {
        return employees.stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(400, id + " employee not found"));
    }

    @Override
    public Employee update(final Employee employee) throws EmployeeNotFoundException {
        final Employee employeeToUpdate = getById(employee.getId());
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setLevel(employee.getLevel());
        employeeToUpdate.setBirthDay(employee.getBirthDay());
        return employeeToUpdate;
    }

    @Override
    public void remove(final Employee employee) {
        employees.remove(employee);
    }

    @Override
    public Long create(final Employee item) {
        employees.add(item);
        return item.getId();
    }
}
