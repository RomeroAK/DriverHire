package com.example.driverhire2.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Table(name = "client")
@Entity
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findbyIdnumber(String email);

    @PostMapping
    Optional<Client> createClient(Client client);
}
