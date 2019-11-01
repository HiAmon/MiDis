package com.amon.wfx.merchant.customer.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerDAOTest {
    @Autowired
    CustomerDAO customerDAO;

    @Test
    void queryCustomerByName() {
        System.out.println(customerDAO.queryCustomerByName("123456"));
    }
}