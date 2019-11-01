package com.amon.wfx.selfmedia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/user/index")
    public String userIndex(){
        return "index";
    }

    @RequestMapping("/index.html")
    public String iindex(){
        return "index";
    }

    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("/register.html")
    public String register(){
        return "register";
    }

    @RequestMapping("wenan.html")
    public String product(){
        return "wenan";
    }

    @RequestMapping("wenan-detail.html")
    public String productDetail(){
        return "wenan-detail";
    }

    @RequestMapping("/pay.html")
    public String pay(){
        return "pay";
    }

    @RequestMapping("/order-details.html")
    public String order(){
        return "order-details";
    }



    @RequestMapping("/goods-list.html")
    public String goodslist(){
        return "goods-list";
    }


}
