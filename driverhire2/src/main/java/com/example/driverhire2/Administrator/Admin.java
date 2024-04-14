package com.example.driverhire2.Administrator;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Administrator")
public class Admin {

    String fName;
    String lName;
    String role;
}
