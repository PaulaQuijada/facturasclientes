package com.facturacionclientes.Domain;

import com.facturacionclientes.Controller.ClientInput;
import com.facturacionclientes.Controller.ClientOutput;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "clients")
@Entity
public class Client {
    private String name;
    private Date birthdate;
    @Id
    private String dni;
    private String country;
    private boolean premium;

    public Client() {
    }

    public Client(String name, Date birthdate, String dni, String country, boolean premium) {
        this.name = name;
        this.birthdate = birthdate;
        this.dni = dni;
        this.country = country;
        this.premium = premium;

    }

    public static Client getClientInput(ClientInput clientInput){
        return new Client(clientInput.getName(), clientInput.getBirthdate(), clientInput.getDni(), clientInput.getCountry(), clientInput.isPremium());
 }
 public static Client getClientOutput(ClientOutput clientOutput){
        return new Client(clientOutput.getName(), clientOutput.getBirthdate(), clientOutput.getDni(), clientOutput.getCountry(), clientOutput.isPremium());
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
