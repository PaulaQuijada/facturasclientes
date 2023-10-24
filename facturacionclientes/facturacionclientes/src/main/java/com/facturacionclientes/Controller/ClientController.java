package com.facturacionclientes.Controller;

import com.facturacionclientes.Repository.ClientRepository;
import com.facturacionclientes.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    private ClientRepository clientRepository;

    @GetMapping("/clients") //Listar TODOS los clientes
    public ResponseEntity<List<ClientOutput>> getClients() {
        try {
            List<ClientOutput> clients = clientService.getAllClients();
            if (clients.isEmpty()) return ResponseEntity.noContent().build();
            else return ResponseEntity.ok(clients);
        } catch (WrongArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (EmptyGapException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
    }

    @PostMapping("/clients")
    public ResponseEntity addClient(@RequestBody ClientInput c) {
        try {
            clientService.addClient(c);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (AlreadyExistsException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/clients/find")
    public ResponseEntity<List<ClientNameDniOutput>> getByTypeAndCountry(@RequestParam boolean premium, @RequestParam String country) {
        try {
            return ResponseEntity.ok(clientService.getClientsPremiumCountry(premium, country));
        } catch (WrongArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.noContent().build();
        } catch (EmptyGapException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
