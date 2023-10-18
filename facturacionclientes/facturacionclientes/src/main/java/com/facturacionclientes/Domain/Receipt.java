package com.facturacionclientes.Domain;

import com.facturacionclientes.Controller.ReceiptInput;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Receipt {
    @Id
    private int codReceipt;
    private float total;
    private int mes;
    private int anyo;
    private String dni;

    public Receipt() {
    }

    public Receipt(int codReceipt, float total, int mes, int anyo, String dni) {
        this.codReceipt = codReceipt;
        this.total = total;
        this.mes = mes;
        this.anyo = anyo;
        this.dni = dni;
    }
 public static Receipt getReceiptInput(ReceiptInput receiptInput){
        return new Receipt(receiptInput.getCodReceipt(), receiptInput.getTotal(), receiptInput.getMes(), receiptInput.getAnyo(), receiptInput.getDni());
 }
    public int getCodReceipt() {
        return codReceipt;
    }

    public void setCodReceipt(int codReceipt) {
        this.codReceipt = codReceipt;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
