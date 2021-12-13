package edu.labs.entities;

public class TaskAssignment {

    private Long id;
    private Task task;
    private Employee employee;
    private Customer reporter;

    public TaskAssignment(final Long id, final Task task, final Employee employee, final Customer reporter) {
        this.id = id;
        this.task = task;
        this.employee = employee;
        this.reporter = reporter;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(final Task task) {
        this.task = task;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    public Customer getReporter() {
        return reporter;
    }

    public void setReporter(final Customer reporter) {
        this.reporter = reporter;
    }
}
