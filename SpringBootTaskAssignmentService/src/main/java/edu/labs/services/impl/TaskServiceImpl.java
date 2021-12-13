package edu.labs.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import edu.labs.converters.TaskConverter;
import edu.labs.dto.TaskDTO;
import edu.labs.entities.Task;
import edu.labs.exceptions.TaskNotFoundException;
import edu.labs.repositories.TaskRepository;
import edu.labs.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    private TaskRepository taskRepository;
    @Resource
    private TaskConverter taskConverter;

    @Override
    public List<TaskDTO> getAllTasks() {
        final List<Task> allTasks = taskRepository.getAll();
        return allTasks.stream().map(item -> taskConverter.toDto(item)).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTaskById(final Long id) throws TaskNotFoundException {
        return taskConverter.toDto(taskRepository.getById(id));
    }

    @Override
    public TaskDTO updateTask(final TaskDTO dto) throws TaskNotFoundException {
        Assert.isNull(dto, "Task dto is null");

        final Task updatedTask = taskRepository.update(taskConverter.toEntity(dto));
        return taskConverter.toDto(updatedTask);
    }

    @Override
    public void removeTask(TaskDTO dto) {
        final Task taskToRemove = taskConverter.toEntity(dto);
        taskRepository.remove(taskToRemove);
    }

    @Override
    public Long createTask(final TaskDTO dto) {
        final Task taskToCreate = taskConverter.toEntity(dto);
        taskRepository.create(taskToCreate);
        return taskToCreate.getId();
    }

    @Override
    public void removeTaskById(final Long id) throws TaskNotFoundException {
        final TaskDTO taskToRemove = getTaskById(id);
        removeTask(taskToRemove);
    }
}
