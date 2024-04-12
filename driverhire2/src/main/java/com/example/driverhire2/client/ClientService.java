package com.example.driverhire2.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(Client client)
    {
        if (client instanceof PrivateClient)
        {
            Optional<Client> tempPrivateClient = clientRepository.findbyEmail(client.getEmail());

            if(tempPrivateClient.isPresent())
            {
                throw new IllegalStateException("This email already exists");

            }

            clientRepository.save(client);

        } else if (client instanceof OrganizationClient)
        {
            Optional<Client> tempOrganizationClient = clientRepository.findbyEmail(client.getEmail());

            if(tempOrganizationClient.isPresent())
            {
                throw new IllegalStateException("This email a;ready exists");

            }

            clientRepository.save(client);

        }

    }

    @Transactional
    public void updateDriver(Long clientId, String email, String address, String contact, String type, String name, String taxNumber)
    {
        Client clientToUpdate  = clientRepository.findbyEmail(email)
                .orElseThrow(()-> new IllegalStateException("Client with " + email + "does not exist"));

        if(clientToUpdate != null)
        {
            if(type.equalsIgnoreCase("Private") && clientToUpdate instanceof PrivateClient)
            {
                PrivateClient privateClient = (PrivateClient) clientToUpdate;
                privateClient.setContact(contact);
                privateClient.setAddress(address);

            } else if (type.equalsIgnoreCase("Organization") && clientToUpdate instanceof OrganizationClient)
            {
                OrganizationClient organizationClient = (OrganizationClient) clientToUpdate;
                organizationClient.setAddress(address);
                organizationClient.setName(name);
                organizationClient.setTaxNumber(taxNumber);
            }
        }

    }

    public void deleteClient(Long clientID)
    {
        Optional<Client> tempClient = clientRepository.findbyID(clientID);
        if(tempClient.isEmpty())
        {
            throw new IllegalStateException("Email" + clientID + " doesn't exist. Please enter another email.");
        }
        clientRepository.deleteById(clientID);
    }

    public List<Client> getClients(Long clientID)
    {
        List<Client> clientsList = clientRepository.findAll();
        return clientsList;
    }
}

