package com.khkeipe.poolQuote.exceptions;

public class NotFoundException extends AppUserException {

    private int status;

    public NotFoundException() {
        super("No resource was found", 404);
    }

    public NotFoundException(String message) {
        super(message, 404);
    }
}
