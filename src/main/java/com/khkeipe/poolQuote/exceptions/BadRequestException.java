package com.khkeipe.poolQuote.exceptions;

public class BadRequestException extends AppUserException{

    private int status;

    public BadRequestException() {
        super("Bad request!", 400);
    }

    public BadRequestException(String message) {
        super(message, 400);
    }
}
