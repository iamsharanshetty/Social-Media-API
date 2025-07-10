package com.devraj.socials.exphandling;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String invalidUsernameOrPassword) {
        super(invalidUsernameOrPassword);
    }
}
