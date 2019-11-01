package com.amon.wfx.selfmedia.member.controller;

import com.amon.wfx.selfmedia.member.pojos.Member;
import com.amon.wfx.selfmedia.member.service.impl.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("/user/login")
    @ResponseBody
    public String userLogin(String data){
        //自媒体登录
        HashMap<String,String> map = new HashMap<>();
        try {
            memberService.checkLogin(data);
            return "true#success";
        } catch (Exception e) {
            e.printStackTrace();
            return "false#fail";
        }

    }

    @RequestMapping("/user/register")
    @ResponseBody
    public HashMap<String,String> register(@RequestBody Member member){
        HashMap<String,String> map = new HashMap<>();
        try {
            memberService.register(member);
            map.put("code","1");
            map.put("msg","reg success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","0");
            map.put("msg","reg fail");
        }
        return map;
    }



    @RequestMapping("/cust/login")
    @ResponseBody
    public String custLogin(){
        //商户登录

        //待完善...
        return "index";
    }
}
