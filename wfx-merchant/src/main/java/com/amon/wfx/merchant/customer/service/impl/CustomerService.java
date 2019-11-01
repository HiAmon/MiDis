package com.amon.wfx.merchant.customer.service.impl;

import com.amon.wfx.merchant.customer.service.ICustomerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class CustomerService implements ICustomerService {

    public Map<String,String> checkLogin(String username,String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        Map<String,String> map = new HashMap<>();
        try{
            subject.login(token);
            map.put("code","1");
            map.put("msg","success");
        }catch (Exception e){
            map.put("code","0");
            map.put("msg","fail");
        }
        return map;
    }
}
