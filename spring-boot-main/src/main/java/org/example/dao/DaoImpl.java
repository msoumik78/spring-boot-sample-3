package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.BankCustomer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DaoImpl implements IDao{

    private final JdbcTemplate jdbcTemplate;

    private final String insertSQL = "INSERT INTO customers(customer_name,customer_age,customer_city,customer_state,customer_profession) VALUES (?,?, ?,?,?)";
    private final String selectSQL = "Select * from customers where customer_name = ?";
    private final String deleteSQL = "Delete from customers where customer_name = ?";
    private final String updateSQL = "Update customers set customer_age = ?, customer_city = ?, customer_state = ?, customer_profession = ? where customer_name = ?";


    @Override
    public void saveInDatabase(BankCustomer bankCustomer) {
        jdbcTemplate.update(insertSQL,bankCustomer.name(), bankCustomer.age(), bankCustomer.city(), bankCustomer.state(), bankCustomer.profession());
    }

    @Override
    public BankCustomer findBankCustomerByName(String customerName) {
        return jdbcTemplate.queryForObject(selectSQL,
                new Object[]{customerName},
                (rs, rowNum) ->
                        new BankCustomer(
                                rs.getString("customer_name"),
                                rs.getInt("customer_age"),
                                rs.getString("customer_city"),
                                rs.getString("customer_state"),
                                rs.getString("customer_profession")
                        ));
    }

    @Override
    public void deleteFromDatabase(String customerName) {
        jdbcTemplate.update(deleteSQL,customerName);
    }

    @Override
    public void updateInDatabase(String customerName, BankCustomer bankCustomer) {
        jdbcTemplate.update(updateSQL, bankCustomer.age(), bankCustomer.city(), bankCustomer.state(), bankCustomer.profession(), customerName);
    }
}
