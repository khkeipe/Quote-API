package com.khkeipe.poolQuote.exceptions;

public class ConflictExecption extends AppUserException{

    private int status;

    public ConflictExecption() {
        super("Conflicting data", 409);

    }

    public ConflictExecption(String message) {
        super(message, 409);
    }

}
