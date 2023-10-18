package com.facturacionclientes.Controller;

public class WrongArgumentException extends Exception{
    public WrongArgumentException(String message) {
        super(message);
    }
}
