package com.facturacionclientes.Controller;

import com.facturacionclientes.Domain.Client;

public class ClientNameDniOutput {
    private String name;
    private String dni;

    public ClientNameDniOutput() {
    }

    public ClientNameDniOutput(String name, String dni) throws WrongArgumentException, EmptyGapException {
        if(name.matches(".*\\d.*")) throw new WrongArgumentException("El nombre no puede contener números");
        if (name == null || name.trim().isEmpty()) throw new EmptyGapException("El nombre no puede estar vacío");
        this.name = name;
        if (dni == null || dni.trim().isEmpty()) throw new EmptyGapException("El DNI no puede estar vacío");
        if (dni.length() != 9 || !Character.isUpperCase(dni.charAt(8))) throw new WrongArgumentException("El DNI ingresado es inválido");
        this.dni = dni;
    }
 public static ClientNameDniOutput getClientNameDni(Client client) throws WrongArgumentException, EmptyGapException {
        return new ClientNameDniOutput(client.getName(), client.getDni());
 }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
