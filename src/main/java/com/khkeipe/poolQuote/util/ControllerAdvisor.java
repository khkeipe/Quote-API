package com.khkeipe.poolQuote.util;

import com.khkeipe.poolQuote.dtos.ErrorResponse;
import com.khkeipe.poolQuote.exceptions.AppUserException;
import com.khkeipe.poolQuote.exceptions.BadRequestException;
import com.khkeipe.poolQuote.exceptions.NotFoundException;
import com.khkeipe.poolQuote.exceptions.ServerErrorException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Component
@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler
    public ErrorResponse handleExecption(AppUserException e, HttpServletResponse resp){
        ErrorResponse err = new ErrorResponse(e);

        if(e instanceof BadRequestException) {
            resp.setStatus(400);
        } else if(e instanceof NotFoundException) {
            resp.setStatus(404);
        } else if(e instanceof ServerErrorException) {
            resp.setStatus(500);
        }

        return err;
    }
}

