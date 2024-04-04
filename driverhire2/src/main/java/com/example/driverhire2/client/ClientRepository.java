package com.example.driverhire2.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Optional;

@Table(name = "client")
@Entity
public interface ClientRepository {
    Optional<Client> findbyIdnumber(String email);
}
