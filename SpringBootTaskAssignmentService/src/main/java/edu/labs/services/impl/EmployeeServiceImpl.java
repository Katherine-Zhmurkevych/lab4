package edu.labs.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import edu.labs.converters.EmployeeConverter;
import edu.labs.dto.EmployeeDTO;
import edu.labs.entities.Employee;
import edu.labs.exceptions.EmployeeNotFoundException;
import edu.labs.repositories.EmployeeRepository;
import edu.labs.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeRepository employeeRepository;
    @Resource
    private EmployeeConverter employeeConverter;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        final List<Employee> allTasks = employeeRepository.getAll();
        return allTasks.stream().map(item -> employeeConverter.toDto(item)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(final Long id) throws EmployeeNotFoundException {
        return employeeConverter.toDto(employeeRepository.getById(id));
    }

    @Override
    public EmployeeDTO updateEmployee(final EmployeeDTO dto) throws EmployeeNotFoundException {
        Assert.isNull(dto, "Employee dto is null");

        final Employee updatedTask = employeeRepository.update(employeeConverter.toEntity(dto));
        return employeeConverter.toDto(updatedTask);
    }

    @Override
    public void removeEmployee(EmployeeDTO dto) {
        final Employee employeeToRemove = employeeConverter.toEntity(dto);
        employeeRepository.remove(employeeToRemove);
    }

    @Override
    public Long createEmployee(final EmployeeDTO dto) {
        final Employee employeeToCreate = employeeConverter.toEntity(dto);
        employeeRepository.create(employeeToCreate);
        return employeeToCreate.getId();
    }

    @Override
    public void removeEmployeeById(final Long id) throws EmployeeNotFoundException {
        final EmployeeDTO employeeToRemove = getEmployeeById(id);
        removeEmployee(employeeToRemove);
    }
}
