package org.example.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query("SELECT t FROM CustomerEntity t WHERE t.customerName=?1")
    CustomerEntity findByCustomerName(String customerName);



    int deleteByCustomerName(String customerName);

}
