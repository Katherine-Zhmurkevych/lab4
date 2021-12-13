package edu.labs.exceptions;

public class EmployeeNotFoundException extends BaseException {
    public EmployeeNotFoundException(final int code, final String message) {
        super(code, message);
    }
}
