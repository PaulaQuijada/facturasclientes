package com.facturacionclientes.Domain;

import com.facturacionclientes.Controller.ClientInput;
import com.facturacionclientes.Controller.ClientOutput;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Client {
    private String name;
    private Date dateOfBirth;
    @Id
    private String dni;
    private String country;
    private boolean premium;

    public Client() {
    }

    public Client(String name, Date dateOfBirth, String dni, String country, boolean premium) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dni = dni;
        this.country = country;
        this.premium = premium;

    }

    public static Client getClientInput(ClientInput clientInput){
        return new Client(clientInput.getName(), clientInput.getDateOfBirth(), clientInput.getDni(), clientInput.getCountry(), clientInput.isPremium());
 }
 public static Client getClientOutput(ClientOutput clientOutput){
        return new Client(clientOutput.getName(), clientOutput.getDateOfBirth(), clientOutput.getDni(), clientOutput.getCountry(), clientOutput.isPremium());
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
