package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.BankCustomer;
import org.example.dao.IDao;
import org.example.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BankCustomersService {

    private final IDao iDao;

    public void createCustomer(BankCustomer bankCustomer) {
        iDao.saveInDatabase(bankCustomer);
    }

    public BankCustomer getCustomerDetail(String bankCustomerName) {
        BankCustomer bankCustomer = iDao.findBankCustomerByName(bankCustomerName);
        if (bankCustomer != null) {
            return bankCustomer;
        } else {
            throw new BusinessException("Bankcustomer : "+bankCustomerName+" not found");
        }
    }

    public void removeCustomer(String bankCustomerName) {
        iDao.deleteFromDatabase(bankCustomerName);
    }

    public void updateCustomer(String bankCustomerName, BankCustomer bankCustomerUpdated) {
        iDao.updateInDatabase(bankCustomerName, bankCustomerUpdated);
    }

}
