package com.amon.wfx.merchant.order.controller;

import com.amon.wfx.merchant.order.pojos.Order;
import com.amon.wfx.merchant.order.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("order/list")
    @ResponseBody
    public HashMap<String,Object> orderlist(){
        HashMap<String,Object> map = new HashMap<>();
        List<Order> orderList = orderService.listOrderAll();
        map.put("orderlist",orderList);
        return map;
    }

    @RequestMapping("order/updateState")
    @ResponseBody
    public HashMap<String,String> updateState(@RequestBody List<String> goodsIds){
        HashMap<String,String> map = new HashMap<>();
        try {
            orderService.changeState(goodsIds);
            map.put("code","1");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","0");
        }
        return map;
    }

}
