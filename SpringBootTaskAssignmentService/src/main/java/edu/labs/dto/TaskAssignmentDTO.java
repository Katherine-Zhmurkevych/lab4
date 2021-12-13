package edu.labs.dto;

import javax.validation.constraints.NotBlank;

import edu.labs.entities.Customer;
import edu.labs.entities.Employee;
import edu.labs.entities.Task;

public class TaskAssignmentDTO {

    private long id;
    @NotBlank
    private Task task;
    @NotBlank
    private Employee employee;
    @NotBlank
    private Customer reporter;

    public TaskAssignmentDTO(final long id, final Task task, final Employee employee, final Customer reporter) {
        this.id = id;
        this.task = task;
        this.employee = employee;
        this.reporter = reporter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getReporter() {
        return reporter;
    }

    public void setReporter(Customer reporter) {
        this.reporter = reporter;
    }
}
