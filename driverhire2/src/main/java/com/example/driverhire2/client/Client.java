package com.example.driverhire2.client;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "client")
public class Client {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "Id", nullable = false)
    Long ID;
    String contact;
    String email;
    String address;
    String password;



    String type;
    String name;

    public Client() {
    }

    public Client(String contact, String email, String address, String type, String name, String password) {
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.type = type;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getContact() {
        return contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
