CREATE DATABASE BankCustomerDB;
USE BankCustomerDB;
CREATE TABLE IF NOT EXISTS customers (
    customer_id INT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(255),
    customer_age INT,
    customer_city VARCHAR(255),
    customer_state VARCHAR(255),
    customer_profession VARCHAR(255),
    PRIMARY KEY (customer_id)

)  ENGINE=INNODB;
INSERT INTO customers(customer_name,customer_age,customer_city,customer_state,customer_profession) VALUES ('soumik',46, 'kolkata','wb','software');
INSERT INTO customers(customer_name,customer_age,customer_city,customer_state,customer_profession) VALUES ('sohini',40, 'kolkata','wb','audit');
