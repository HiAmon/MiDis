package com.amon.wfx.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String index(){

        return "index";
    }

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/lessPermission")
    public String lose(){

        return "lessPermission";
    }

    @RequestMapping("/goods-list.html")
    public String goodsList(){

        return "goods-list";
    }

//    @RequestMapping("/page/grant-permission.html")
//    @ResponseBody
//    public String grantPermission(){
//
//        return "page/grant-permission";
//    }


}
