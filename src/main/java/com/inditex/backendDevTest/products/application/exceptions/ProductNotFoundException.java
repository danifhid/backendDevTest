package com.inditex.backendDevTest.products.application.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super(" Product not found");
    }
}
