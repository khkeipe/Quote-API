package com.khkeipe.poolQuote.exceptions;

public class ServerErrorException extends AppUserException{

    private int status;

    public ServerErrorException() {
        super("Internal server error occured", 500);
    }

    public ServerErrorException(String message) {
        super(message, 500);
    }
}
