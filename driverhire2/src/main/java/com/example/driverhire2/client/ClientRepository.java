package com.example.driverhire2.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Table(name = "client")
@Entity
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.email = ?1")
    Optional<Client> findbyEmail(String email);

    @Query("SELECT c FROM Client c WHERE c.ID = ?1")
    Optional<Client> findbyID(Long ID);

}
