package com.amon.wfx.merchant.customer.controller;

import com.amon.wfx.merchant.customer.pojos.Customer;
import com.amon.wfx.merchant.customer.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping("customer/login")
    @ResponseBody
    public Map<String,String> login(String username,String password){
        System.out.println("1");
        return customerService.checkLogin(username,password);
    }
}
