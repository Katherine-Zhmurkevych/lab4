package edu.labs.converters;

import org.springframework.stereotype.Component;

import edu.labs.dto.TaskDTO;
import edu.labs.entities.Task;

@Component
public class TaskConverter implements EntityConverter<Task, TaskDTO> {

    @Override
    public Task toEntity(final TaskDTO dto) {
        return new Task(dto.getId(), dto.getSummary(), dto.getDescription(), dto.getStatus());
    }

    @Override
    public TaskDTO toDto(final Task item) {
        return new TaskDTO(item.getId(), item.getSummary(), item.getDescription(), item.getStatus());
    }
}
