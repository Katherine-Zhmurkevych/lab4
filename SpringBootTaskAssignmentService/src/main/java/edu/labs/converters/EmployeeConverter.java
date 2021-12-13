package edu.labs.converters;

import edu.labs.dto.EmployeeDTO;
import edu.labs.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter implements EntityConverter<Employee, EmployeeDTO> {

    @Override
    public Employee toEntity(final EmployeeDTO dto) {
        return new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLevel(), dto.getBirthDay());
    }

    @Override
    public EmployeeDTO toDto(final Employee item) {
        return new EmployeeDTO(item.getId(), item.getFirstName(), item.getLastName(), item.getLevel(), item.getBirthDay());
    }
}
