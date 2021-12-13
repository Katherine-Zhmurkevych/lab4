package edu.labs.services;

import java.util.List;

import edu.labs.dto.EmployeeDTO;
import edu.labs.exceptions.BaseException;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(final Long id) throws BaseException;

    EmployeeDTO updateEmployee(EmployeeDTO dto) throws BaseException;

    void removeEmployee(EmployeeDTO dto);

    Long createEmployee(EmployeeDTO dto);

    void removeEmployeeById(Long id) throws BaseException;
}
