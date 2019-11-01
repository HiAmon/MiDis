package com.amon.wfx.merchant.order.service.impl;

import com.amon.wfx.merchant.goods.dao.GoodDAO;
import com.amon.wfx.merchant.goods.dao.SkuDAO;
import com.amon.wfx.merchant.order.dao.OrderDAO;
import com.amon.wfx.merchant.order.pojos.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    GoodDAO goodDAO;
    @Autowired
    SkuDAO skuDAO;

    public List<Order> listOrderAll(){
       List<Order> orderList = orderDAO.listOrderAll();

       return orderList;
    }

    public void changeState(List<String> goodsIds) throws Exception{

        for (String goodsId:goodsIds) {
            orderDAO.updateStateByGoodId(goodsId);
        }


    }
}
