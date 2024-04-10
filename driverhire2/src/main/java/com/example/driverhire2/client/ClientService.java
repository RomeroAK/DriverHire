package com.example.driverhire2.client;

import com.example.driverhire2.driver.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client)
    {
        if (client instanceof PrivateClient)
        {
            PrivateClient privateClient = (PrivateClient) client;
            privateClient.setPassword(privateClient.password);
            privateClient.setName(privateClient.name);
            privateClient.setLastName(privateClient.lastName);
            privateClient.setIdNumber(privateClient.idNumber);
            privateClient.setAddress(privateClient.address);
            privateClient.setContact(privateClient.contact);
            privateClient.setEmail(privateClient.email);
            privateClient.setType(privateClient.type);

        } else if (client instanceof OrganizationClient)
        {
            OrganizationClient organizationClient = (OrganizationClient) client;
            organizationClient.setName(organizationClient.name);
            organizationClient.setAddress(organizationClient.address);
            organizationClient.setEmail(organizationClient.email);
            organizationClient.setTaxNumber(organizationClient.taxNumber);
            organizationClient.setType(organizationClient.type);

        }
        return client;
    }

    @Transactional
    public void updateDriver(Long clientId, String email, String address, String contact, String type, String name)
    {
        Client clientToUpdate  = clientRepository.findbyIdnumber(email)
                .orElseThrow(()-> new IllegalStateException("Client with " + email + "does not exist"));

        if(clientToUpdate != null)
        {
            if(type.equalsIgnoreCase("privatclient") && clientToUpdate instanceof PrivateClient)
            {
                PrivateClient privateClient = (PrivateClient) clientToUpdate;
                privateClient.setContact(contact);
                privateClient.setAddress(address);

            }
        }

    }
}

