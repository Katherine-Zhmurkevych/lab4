package edu.labs.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import edu.labs.entities.Customer;
import edu.labs.entities.Employee;
import edu.labs.entities.Task;
import edu.labs.entities.TaskAssignment;
import edu.labs.exceptions.TaskAssignmentNotFoundException;

@Repository
public class TaskAssignmentRepository implements CrudRepository<TaskAssignment>{
    private final List<TaskAssignment> taskAssignments = new ArrayList<>();
    
    @Override
    public List<TaskAssignment> getAll() {
        return taskAssignments;
    }

    @Override
    public TaskAssignment getById(final Long id) throws TaskAssignmentNotFoundException {
        return taskAssignments.stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElseThrow(() -> new TaskAssignmentNotFoundException(400, id + " TaskAssignment not found"));
    }

    @Override
    public TaskAssignment update(final TaskAssignment taskAssignment) throws TaskAssignmentNotFoundException {
        final TaskAssignment taskAssignmentToUpdate = getById(taskAssignment.getId());
        taskAssignmentToUpdate.setTask(taskAssignment.getTask());
        taskAssignmentToUpdate.setEmployee(taskAssignment.getEmployee());
        taskAssignmentToUpdate.setReporter(taskAssignment.getReporter());
        return taskAssignmentToUpdate;
    }

    @Override
    public void remove(final TaskAssignment taskAssignment) {
        taskAssignments.remove(taskAssignment);
    }

    @Override
    public Long create(final TaskAssignment taskAssignment) {
        taskAssignments.add(taskAssignment);
        return taskAssignment.getId();
    }

    public List<Task> findTasksByEmployee(final Employee employee){
        return taskAssignments.stream().filter(item->item.getEmployee().equals(employee)).map(TaskAssignment::getTask).collect(
                Collectors.toList());
    }

    public List<Task> findTasksByReporter(final Customer customer) {
        return taskAssignments.stream().filter(item->item.getReporter().equals(customer)).map(TaskAssignment::getTask).collect(
                Collectors.toList());
    }
}
