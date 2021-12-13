package edu.labs.exceptions;

public class TaskNotFoundException extends BaseException {

    public TaskNotFoundException(final int code, final String message) {
        super(code, message);
    }
}
