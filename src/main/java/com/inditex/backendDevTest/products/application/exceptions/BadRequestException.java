package com.inditex.backendDevTest.products.application.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Bad Request");
    }
}
