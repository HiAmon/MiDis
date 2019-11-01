package com.amon.wfx.selfmedia.order.dao;

import com.amon.wfx.selfmedia.order.pojos.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO {

    void addOrder(Order order);
}
