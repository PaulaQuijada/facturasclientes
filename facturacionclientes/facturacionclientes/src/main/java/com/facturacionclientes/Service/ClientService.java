package com.facturacionclientes.Service;

import com.facturacionclientes.Controller.*;
import com.facturacionclientes.Domain.Client;
import com.facturacionclientes.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void addClient(ClientInput clientInput) throws AlreadyExistsException {
        if (clientRepository.existsById(clientInput.getDni()))
            throw new AlreadyExistsException("El cliente ya existe");
        else {
            Client c = Client.getClientInput(clientInput);
            clientRepository.save(c);
        }
    }

    public List<ClientOutput> getAllClients() throws WrongArgumentException, EmptyGapException {
        List<Client> clients = clientRepository.findAll();
        List<ClientOutput> clientsOutput = new ArrayList<>();
        for (Client client : clients) {
            ClientOutput clientOutput = ClientOutput.getClient(client);
            clientsOutput.add(clientOutput);
        }
        return clientsOutput;
    }

    public List<ClientNameDniOutput> getClientsPremiumCountry(boolean premium, String country) throws EmptyListException, WrongArgumentException, EmptyGapException {
        List<Client> clients = clientRepository.findByPremiumAndCountryOrderByNameAsc(premium, country);

        if (clients == null || clients.isEmpty()) {
            throw new EmptyListException("La lista de clientes está vacía");
        } else {
            List<ClientNameDniOutput> clientsNameDni = new ArrayList<>();
            for (Client client : clients) {
                ClientNameDniOutput c = ClientNameDniOutput.getClientNameDni(client);
                clientsNameDni.add(c);
            }
            return clientsNameDni;
        }
    }


}
