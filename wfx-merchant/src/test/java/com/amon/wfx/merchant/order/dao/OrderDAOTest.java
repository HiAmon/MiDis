package com.amon.wfx.merchant.order.dao;

import com.amon.wfx.merchant.order.pojos.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class OrderDAOTest {
    @Autowired
    OrderDAO orderDAO;

    @Test
    void listOrderAll() {
        List<Order> orderList = orderDAO.listOrderAll();
        for (Order order:orderList ) {
            System.out.println(order.getGoodName());
        }
    }
}