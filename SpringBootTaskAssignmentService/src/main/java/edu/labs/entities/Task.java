package edu.labs.entities;

import edu.labs.enums.TaskStatus;

public class Task {

    private Long id;
    private String summary;
    private String description;
    private TaskStatus status;

    public Task() {
    }

    public Task(final long id, final String summary, final String description, final TaskStatus status) {
        this.id = id;
        this.summary = summary;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(final String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(final TaskStatus status) {
        this.status = status;
    }

}
