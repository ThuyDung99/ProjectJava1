package hust.dungttt.model;

import java.util.Date;

public class EnterpriseCustomer extends Customer{
    private int taxCode;
    private String owner;
    private String website;

    public EnterpriseCustomer(int taxCode, String owner, String website) {
        this.taxCode = taxCode;
        this.owner = owner;
        this.website = website;
    }

    public EnterpriseCustomer(int id, String username, String password, String fullName, String dateOfBirth, String address, String phoneNumber, String email, int productQuantity, double moneySpent, int purchaseNumber, Date createDate, Date modifyDate, boolean deleted, int taxCode, String owner, String website) {
        super(id, username, password, fullName, dateOfBirth, address, phoneNumber, email, productQuantity, moneySpent, purchaseNumber, createDate, modifyDate, deleted);
        this.taxCode = taxCode;
        this.owner = owner;
        this.website = website;
    }

    public EnterpriseCustomer() {
    }

    @Override
    public String toString() {
        return "EnterpriseCustomer{" +
                "taxCode=" + taxCode +
                ", owner='" + owner + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    public int getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(int taxCode) {
        this.taxCode = taxCode;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
