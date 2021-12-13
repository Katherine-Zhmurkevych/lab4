package edu.labs.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.labs.entities.Task;
import edu.labs.exceptions.TaskNotFoundException;

@Repository
public class TaskRepository implements CrudRepository<Task> {

    private final List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getAll() {
        return tasks;
    }

    @Override
    public Task getById(final Long id) throws TaskNotFoundException {
        return tasks.stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElseThrow(() -> new TaskNotFoundException(400, id + " Task not found"));
    }

    @Override
    public Task update(final Task task) throws TaskNotFoundException {
        final Task taskToUpdate = getById(task.getId());
        taskToUpdate.setSummary(task.getSummary());
        taskToUpdate.setStatus(task.getStatus());
        taskToUpdate.setDescription(task.getDescription());
        return taskToUpdate;
    }

    @Override
    public void remove(final Task task) {
        tasks.remove(task);
    }

    @Override
    public Long create(final Task task) {
        tasks.add(task);
        return task.getId();
    }

}
