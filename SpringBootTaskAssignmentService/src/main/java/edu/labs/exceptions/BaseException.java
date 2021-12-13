package edu.labs.exceptions;

public class BaseException extends Exception {

    private int code;
    private String message;

    public BaseException(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
