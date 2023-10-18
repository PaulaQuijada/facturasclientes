package com.facturacionclientes.Controller;

import com.facturacionclientes.Domain.Receipt;

import java.time.Year;

public class ReceiptOutput {
    private int codReceipt;
    private float total;
    private int mes;
    private int anyo;
    private String dni;

    public ReceiptOutput() {
    }

    public ReceiptOutput(int codReceipt, float total, int mes, int anyo, String dni) throws WrongArgumentException, EmptyGapException {
        if(codReceipt <=0) throw new WrongArgumentException("El código de factura no puede ser menor a 0");
        this.codReceipt = codReceipt;
        if(total <=0) throw new WrongArgumentException("El total no puede ser menor a 0");
        this.total = total;
        if(mes <01 || mes >12 ) throw new WrongArgumentException("El mes introducido no es válido");
        this.mes = mes;
        if(anyo > Year.now().getValue() || anyo <1990) throw new WrongArgumentException("El año de la factura debe estar entre 1990 y " + Year.now().getValue());
        this.anyo = anyo;
        if (dni == null || dni.trim().isEmpty()) throw new EmptyGapException("El DNI no puede estar vacío");
        if (dni.length() != 9 || !Character.isUpperCase(dni.charAt(8))) throw new WrongArgumentException("El DNI ingresado es inválido");
        this.dni = dni;
    }
 public static ReceiptOutput getReceipt (Receipt receipt) throws WrongArgumentException, EmptyGapException {
        return new ReceiptOutput(receipt.getCodReceipt(), receipt.getTotal(), receipt.getMes(), receipt.getAnyo(), receipt.getDni());
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
