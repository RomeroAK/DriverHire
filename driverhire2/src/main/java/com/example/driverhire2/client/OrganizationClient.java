package com.example.driverhire2.client;

public class OrganizationClient extends Client{

    String taxNumber;

    public OrganizationClient() {
    }

    public OrganizationClient(String contact, String email, String address, String name, String taxNumber, String type, String password) {
        super(contact, email, address, type, name, password);

        this.taxNumber = taxNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Override
    public String toString() {
        return "OrganizationClient{" +
                "taxNumber='" + taxNumber + '\'' +
                ", ID=" + ID +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
