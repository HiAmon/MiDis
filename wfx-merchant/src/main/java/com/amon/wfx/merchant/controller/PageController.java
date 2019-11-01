package com.amon.wfx.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PageController {

    @RequestMapping("/goods_list.html")
    public String listgoods(){
        return "goods_list";
    }

    @RequestMapping("/goods_add.html")
    public String addgoods(){
        return "goods_add";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/index.html")
    public String index1(){

        return "index";
    }

    @RequestMapping("/test.html")
    public String test(){

        return "test";
    }

@RequestMapping("/order.html")
    public String order(){

        return "order";
    }



}
