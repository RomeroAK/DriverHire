package com.example.driverhire2.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PutMapping(path = "{clientId}")
    public void updateClient(@PathVariable("clientId") Long clientId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String address,
                             @RequestParam(required = false) String contact,
                             @RequestParam(required = false) String type,
                             @RequestParam(required = false) String taxNumber,
                             @RequestParam(required = false) String email) {

        clientService.updateDriver(clientId, name, address, contact, type, taxNumber, email);

    }

    @PostMapping
    public void addNewClient(@RequestBody Client client)
    {
        clientService.createClient(client);
    }

    @DeleteMapping
    public void deleteClient(Long clientId)
    {
        clientService.deleteClient(clientId);
    }

    @GetMapping
    public List<Client> getClients(Long clientId)
    {

        List<Client> clients = clientService.getClients(clientId);

        return clients;
    }

}
