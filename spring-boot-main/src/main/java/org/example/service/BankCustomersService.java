package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.BankCustomer;
import org.example.dao.CustomerEntity;
import org.example.dao.CustomerRepository;
import org.example.exception.BusinessException;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BankCustomersService {

    private final CustomerRepository customerRepository;

    public void createCustomer(BankCustomer bankCustomer) {
        customerRepository.save(convertFromModelToEntity(bankCustomer));
    }

    public BankCustomer getCustomerDetail(String bankCustomerName) {
        CustomerEntity customerEntity = customerRepository.findByCustomerName(bankCustomerName);
        if (customerEntity != null) {
            return convertFromEntityToModel(customerEntity);
        } else {
            throw new BusinessException("Bankcustomer : "+bankCustomerName+" not found");
        }
    }

    public void removeCustomer(String bankCustomerName) {
        customerRepository.deleteByCustomerName(bankCustomerName);
    }

    public void updateCustomer(String bankCustomerName, BankCustomer bankCustomerUpdated) {
        customerRepository.save(new CustomerEntity());
    }

    private CustomerEntity convertFromModelToEntity(BankCustomer bankCustomer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerName(bankCustomer.name());
        customerEntity.setCustomerAge(bankCustomer.age());
        customerEntity.setCustomerCity(bankCustomer.city());
        customerEntity.setCustomerState(bankCustomer.state());
        customerEntity.setCustomerProfession(bankCustomer.profession());
        return customerEntity;
    }

    private BankCustomer convertFromEntityToModel(CustomerEntity customerEntity) {
       return new BankCustomer(
                customerEntity.getCustomerName(),
                customerEntity.getCustomerAge(),
                customerEntity.getCustomerCity(),
                customerEntity.getCustomerState(),
                customerEntity.getCustomerProfession()
       );
    }



}
