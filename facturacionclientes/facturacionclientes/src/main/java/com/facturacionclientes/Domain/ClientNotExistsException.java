package com.facturacionclientes.Domain;

public class ClientNotExistsException extends Exception{
    public ClientNotExistsException(String message) {
        super(message);
    }
}
