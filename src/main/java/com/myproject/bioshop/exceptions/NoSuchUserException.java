package com.myproject.bioshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "")
public class NoSuchUserException extends Exception{

    private int status;

    public NoSuchUserException() {
        this.status = 404;
    }

    public NoSuchUserException(String message) {
        super(message);
        this.status = 404;
    }

    public int getStatus() {
        return status;
    }

}
