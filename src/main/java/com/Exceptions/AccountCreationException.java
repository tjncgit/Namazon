package com.Exceptions;

public class AccountCreationException extends Exception{
    private String msg;

    public AccountCreationException(String msg) {
        super(msg);
    }
}
