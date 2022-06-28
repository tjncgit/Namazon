package com.Exceptions;

public class ProductNotAvailableException extends Exception{
    private String msg;

    public ProductNotAvailableException(String msg) {
        super(msg);
    }
}
