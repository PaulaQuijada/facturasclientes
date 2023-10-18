package com.facturacionclientes.Service;

import com.facturacionclientes.Controller.*;
import com.facturacionclientes.Domain.Client;
import com.facturacionclientes.Domain.ClientNotExistsException;
import com.facturacionclientes.Domain.Receipt;
import com.facturacionclientes.Repository.ClientRepository;
import com.facturacionclientes.Repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private ClientRepository clientRepository;


    public void addReceipt(ReceiptInput receiptInput) throws AlreadyExistsException, EmptyListException {
        if (receiptRepository.existsById(receiptInput.getCodReceipt()))
            throw new AlreadyExistsException("La factura ya existe");
        else {
                Receipt r = Receipt.getReceiptInput(receiptInput);
                receiptRepository.save(r);
            }
        }


    public List<ReceiptOutput> getAllReceipts() throws WrongArgumentException, EmptyGapException {
        List<Receipt> receipts = receiptRepository.findAll();
        List<ReceiptOutput> receiptsOutput = new ArrayList<>();
        for (Receipt receipt : receipts) {
            ReceiptOutput receiptOutput = ReceiptOutput.getReceipt(receipt);
            receiptsOutput.add(receiptOutput);

        }
        return receiptsOutput;
    }


    public List<ReceiptCodTotalOutput> getReceiptsClient(String dni) throws ClientNotExistsException, WrongArgumentException {
        if (clientRepository.existsById(dni)) {
            List<Receipt> receipts = receiptRepository.findAll();
            List<ReceiptCodTotalOutput> receiptsCodTotal = new ArrayList<>();
            for (Receipt receipt : receipts) {
                ReceiptCodTotalOutput receiptCodTotal = ReceiptCodTotalOutput.getReceipt(receipt);
                receiptsCodTotal.add(receiptCodTotal);
            }
            return receiptsCodTotal;
        } else throw new ClientNotExistsException("El cliente no existe");

    }

    public List<ReceiptOutput> getReceiptMesAnyo(int mes, int anyo) throws EmptyGapException, WrongArgumentException {
        List<Receipt> receipts = receiptRepository.findByMesAndAnyo(mes, anyo);
        List<ReceiptOutput> receiptsMesAnyo = new ArrayList<>();
        for (Receipt receipt : receipts) {
            ReceiptOutput receiptOutput = ReceiptOutput.getReceipt(receipt);
            receiptsMesAnyo.add(receiptOutput);
        }
        return receiptsMesAnyo;
    }

}
