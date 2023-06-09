package org.example.dao;

import org.example.BankCustomer;

public interface IDao {

    public void saveInDatabase(BankCustomer bankCustomer);
    public BankCustomer findBankCustomerByName(String customerName);

    public void deleteFromDatabase(String customerName);

    public void updateInDatabase(String customerName, BankCustomer bankCustomer);

}
