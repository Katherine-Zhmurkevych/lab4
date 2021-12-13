package edu.labs.exceptions;

public class TaskAssignmentNotFoundException extends BaseException {

    public TaskAssignmentNotFoundException(final int code, final String message) {
        super(code, message);
    }
}
