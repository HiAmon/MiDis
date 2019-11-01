package com.amon.wfx.merchant.order.dao;

import com.amon.wfx.merchant.order.pojos.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO {

    List<Order> listOrderAll();

    void updateStateByGoodId(String goodId);
}
