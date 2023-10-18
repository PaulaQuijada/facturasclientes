package com.facturacionclientes.Controller;

import com.facturacionclientes.Domain.Client;

import java.util.Date;

public class ClientOutput {
    private String name;
    private Date dateOfBirth;
    private String dni;
    private String country;
    private boolean premium;

    public ClientOutput() {
    }

    public ClientOutput(String name, Date dateOfBirth, String dni, String country, boolean premium) throws WrongArgumentException, EmptyGapException {
        if(name.matches(".*\\d.*")) throw new WrongArgumentException("El nombre no puede contener números");
        if (name == null || name.trim().isEmpty()) throw new EmptyGapException("El nombre no puede estar vacío");
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        if (dni == null || dni.trim().isEmpty()) throw new EmptyGapException("El DNI no puede estar vacío");
        if (dni.length() != 9 || !Character.isUpperCase(dni.charAt(8))) throw new WrongArgumentException("El DNI ingresado es inválido");
        this.dni = dni;
        if(country.matches(".*\\d.*")) throw new WrongArgumentException("El nombre no puede contener números");
        if (country == null || country.trim().isEmpty()) throw new EmptyGapException("El nombre no puede estar vacío");
        this.country = country;
        this.premium = premium;

    }
    public static ClientOutput getClient(Client client) throws WrongArgumentException, EmptyGapException {
        return new ClientOutput(client.getName(),client.getDateOfBirth(), client.getDni(), client.getCountry(), client.isPremium());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
