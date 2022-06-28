package com.Exceptions;

public class AccountAuthenticationException extends Exception{
    private String msg;

    public AccountAuthenticationException(String msg) {
        super(msg);
    }
}
