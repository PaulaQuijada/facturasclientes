package com.facturacionclientes.Controller;

import com.facturacionclientes.Domain.Client;

import java.util.Date;

public class ClientInput {
    private String name;
    private Date birthdate;
    private String dni;
    private String country;
    private boolean premium;


    public ClientInput() {
    }

    public ClientInput(String name, Date birthdate, String dni, String country, boolean premium) throws WrongArgumentException, EmptyGapException {
        if(name.matches(".*\\d.*")) throw new WrongArgumentException("El nombre no puede contener números");
        if (name == null || name.trim().isEmpty()) throw new EmptyGapException("El nombre no puede estar vacío");
        this.name = name;
        if(birthdate == null) throw new WrongArgumentException("La fecha de nacimiento no puede ser nula");
        this.birthdate = birthdate;
        if (dni == null || dni.trim().isEmpty()) throw new EmptyGapException("El DNI no puede estar vacío");
        if (dni.length() != 9 || !Character.isUpperCase(dni.charAt(8))) throw new WrongArgumentException("El DNI ingresado es inválido");
        this.dni = dni;
        if(country.matches(".*\\d.*")) throw new WrongArgumentException("El nombre no puede contener números");
        if (country == null || country.trim().isEmpty()) throw new EmptyGapException("El nombre no puede estar vacío");
        this.country = country;
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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
