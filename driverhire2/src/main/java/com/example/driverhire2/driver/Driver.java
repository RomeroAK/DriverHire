package com.example.driverhire2.driver;

import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 255, nullable = false)
    @Id
    Long ID;

    String Idnumber;
    String firstName;
    String lastName;
    String gender;
    int experience;

    public Driver() {
    }



    public Driver(String IDnumber, String firstName, String lastName, String gender, int experience) {
        this.Idnumber = IDnumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.experience = experience;

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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "ID=" + ID +
                ", Idnumber='" + Idnumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", experience=" + experience +
                '}';
    }
}
