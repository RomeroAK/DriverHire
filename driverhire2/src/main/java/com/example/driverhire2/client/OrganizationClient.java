package com.example.driverhire2.client;

public class OrganizationClient extends Client{

    String companyName;
    String taxNumber;

    public OrganizationClient() {
    }

    public OrganizationClient(String contact, String email, String address, String companyName, String taxNumber, String type) {
        super(contact, email, address, type);
        this.companyName = companyName;
        this.taxNumber = taxNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
                "companyName='" + companyName + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", ID=" + ID +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
