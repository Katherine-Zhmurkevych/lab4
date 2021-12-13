package edu.labs.services;

import java.util.List;

import edu.labs.dto.TaskDTO;
import edu.labs.exceptions.BaseException;

public interface TaskService {
    List<TaskDTO> getAllTasks();

    TaskDTO getTaskById(final Long id) throws BaseException;

    TaskDTO updateTask(TaskDTO dto) throws BaseException;

    void removeTask(TaskDTO dto);

    Long createTask(TaskDTO dto);

    void removeTaskById(Long id) throws BaseException;
}
