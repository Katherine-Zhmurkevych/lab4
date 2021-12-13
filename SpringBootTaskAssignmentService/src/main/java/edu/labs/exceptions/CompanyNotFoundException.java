package edu.labs.exceptions;

public class CompanyNotFoundException extends BaseException {

    public CompanyNotFoundException(final int code, final String message) {
        super(code, message);
    }
}
