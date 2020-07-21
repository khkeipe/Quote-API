package com.khkeipe.poolQuote.exceptions;

public class DataPercistanceExecption extends AppUserException {

    private int status;

    public DataPercistanceExecption() {
        super("Data was not stored", 304);

    }

    public DataPercistanceExecption(String message) {
        super(message, 304);
    }
}
