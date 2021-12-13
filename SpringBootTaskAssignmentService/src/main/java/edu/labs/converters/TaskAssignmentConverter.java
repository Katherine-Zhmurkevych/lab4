package edu.labs.converters;

import edu.labs.dto.TaskAssignmentDTO;
import edu.labs.entities.TaskAssignment;
import org.springframework.stereotype.Component;

@Component
public class TaskAssignmentConverter implements EntityConverter<TaskAssignment, TaskAssignmentDTO> {

    @Override
    public TaskAssignment toEntity(final TaskAssignmentDTO dto) {
        return new TaskAssignment(dto.getId(), dto.getTask(), dto.getEmployee(), dto.getReporter());
    }

    @Override
    public TaskAssignmentDTO toDto(final TaskAssignment item) {
        return new TaskAssignmentDTO(item.getId(), item.getTask(), item.getEmployee(), item.getReporter());
    }
}
