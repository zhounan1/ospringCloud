package com.aust.security.exception;

public class AppSecurityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AppSecurityException(String msg) {
        super(msg);
    }

    public AppSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppSecurityException(Throwable cause) {
        super(cause);
    }
}
