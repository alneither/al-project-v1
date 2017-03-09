package org.al.adsystem.exception;

public class UserAuthenticationException extends RuntimeException {

    public UserAuthenticationException() {
        super();
    }

    public UserAuthenticationException(String message) {
        super(message);
    }
}
