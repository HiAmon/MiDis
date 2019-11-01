package com.amon.wfx.manager.urp.controller;

import com.amon.wfx.manager.urp.pojos.User;
import com.amon.wfx.manager.urp.service.impl.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /*
    此方法是用在管理页面，用户管理列表中
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<User> userInfo(String username, String password){
        return userService.listAllUsers();
    }

    /*
    此方法用于登录页面
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> login(String username,String password){
        Map<String,String> map = new HashMap<>();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            map.put("code","1");
            map.put("msg","success");
        }catch (Exception e){
            map.put("code","0");
            map.put("msg","fail");
        }
        return map;
    }

    @RequestMapping("/unable")
    @ResponseBody
    public String userUnable(String userId){
        userService.unableUser(userId);
        return "ok";
    }

    @RequestMapping("/resetPasswd")
    @ResponseBody
    public String resetPasswd(String userId){
        userService.resetPasswd(userId);
        return "ok";
    }
}
