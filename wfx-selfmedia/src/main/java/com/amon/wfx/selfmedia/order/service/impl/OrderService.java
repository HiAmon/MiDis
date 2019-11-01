package com.amon.wfx.selfmedia.order.service.impl;

import com.amon.wfx.selfmedia.order.dao.OrderDAO;
import com.amon.wfx.selfmedia.order.pojos.Order;
import com.amon.wfx.selfmedia.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderDAO orderDAO;

    public String addOrder(Order order) throws Exception{
        //订单信息尚未补全...

        //1.生成订单号
        String orderId = System.currentTimeMillis()+""+((int)Math.random()*10000000+10000000);

        //2.记录下单时间

        order.setOrderId(orderId);
        order.setOrderTime(new Date());

        orderDAO.addOrder(order);
        return orderId;
    }
}
