package com.facturacionclientes.Controller;

import com.facturacionclientes.Domain.Receipt;

public class ReceiptCodTotalOutput {
    private int codReceipt;
    private float total;

    public ReceiptCodTotalOutput() {
    }

    public ReceiptCodTotalOutput(int codReceipt, float total) throws WrongArgumentException {
        if(codReceipt <=0) throw new WrongArgumentException("El código de factura no puede ser menor a 0");
        this.codReceipt = codReceipt;
        if(total <=0) throw new WrongArgumentException("El código de factura no puede ser menor a 0");
        this.total = total;
    }
public static ReceiptCodTotalOutput getReceipt(Receipt r) throws WrongArgumentException {
        return new ReceiptCodTotalOutput(r.getCodReceipt(), r.getTotal());
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
}
