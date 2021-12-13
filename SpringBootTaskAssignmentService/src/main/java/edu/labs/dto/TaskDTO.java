package edu.labs.dto;

import javax.validation.constraints.NotBlank;

import edu.labs.enums.TaskStatus;

public class TaskDTO {

    private Long id;
    @NotBlank
    private String summary;
    private String description;
    @NotBlank
    private TaskStatus status;

    public TaskDTO(final long id, final String summary, final String description, final TaskStatus status) {
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
