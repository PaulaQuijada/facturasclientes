package com.facturacionclientes.Controller;

import com.facturacionclientes.Domain.ClientNotExistsException;
import com.facturacionclientes.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @GetMapping("/receipts") //Lista de TODAS las facturas
    public ResponseEntity<List<ReceiptOutput>> getReceipts(){
       try{ List<ReceiptOutput> receipts = receiptService.getAllReceipts();
        if(receipts.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(receipts);
    }
       catch (WrongArgumentException e){
           System.out.println(e.getMessage());
           return ResponseEntity.badRequest().build();
       }
       catch (EmptyGapException e){
           System.out.println(e.getMessage());
           return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
       }
    }
    @PostMapping("/receipts")
    public ResponseEntity addReceipt(@RequestBody ReceiptInput r) {
        try {
            receiptService.addReceipt(r);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (AlreadyExistsException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/receipts/{dni}")
    public ResponseEntity<List<ReceiptCodTotalOutput>> getReceiptsClient(@PathVariable String dni){
        try{
            return ResponseEntity.ok(receiptService.getReceiptsClient(dni));
        } catch (ClientNotExistsException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (WrongArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/receipts/find")
    public ResponseEntity<List<ReceiptOutput>> getReceiptsMesAnyo(@RequestParam int mes, @RequestParam int anyo){
           try{ return ResponseEntity.ok(receiptService.getReceiptMesAnyo(mes,anyo));
    }
           catch (WrongArgumentException e){
               System.out.println(e.getMessage());
               return ResponseEntity.badRequest().build();
           }
           catch (EmptyGapException e){
               System.out.println(e.getMessage());
               return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
           }
    }

}
