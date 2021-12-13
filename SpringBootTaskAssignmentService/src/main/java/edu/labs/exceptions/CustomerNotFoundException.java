package edu.labs.exceptions;

public class CustomerNotFoundException extends BaseException {
    public CustomerNotFoundException(final int code, final String message) {
        super(code, message);
    }
}
