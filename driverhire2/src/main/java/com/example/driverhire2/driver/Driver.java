package com.example.driverhire2.driver;

import jakarta.persistence.*;

@Entity
@Table
public class Driver {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 255, nullable = false)
    @Id
    Long ID;

    String Idnumber;
    String firstName;
    String lastName;
    String gender;

    public Driver() {
    }

    public Driver(String IDnumber, String firstName, String lastName, String gender) {
        this.Idnumber = IDnumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getIDnumber() {
        return Idnumber;
    }

    public void setIdnumber(String Idnumber) {
        this.Idnumber = Idnumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "ID=" + ID +
                ", Idnumber='" + Idnumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
