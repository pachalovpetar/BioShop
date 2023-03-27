package com.myproject.bioshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "product exists")
public class ProductDuplicateException extends RuntimeException {

    private int status;

    public ProductDuplicateException() {
        this.status = 400;
    }

    public ProductDuplicateException(String message) {
        super(message);
        this.status = 404;
    }

    public int getStatus() {
        return status;
    }
}
