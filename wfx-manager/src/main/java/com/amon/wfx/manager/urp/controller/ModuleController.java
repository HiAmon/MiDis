package com.amon.wfx.manager.urp.controller;

import com.amon.wfx.manager.urp.pojos.Level1Module;
import com.amon.wfx.manager.urp.pojos.User;
import com.amon.wfx.manager.urp.service.impl.ModuleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Level1Module> moduleList(){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        String account = user.getAccount();
        //用于获取当前账户的所有权限模块，放到三层权限树中
        List<Level1Module> level1Modules = moduleService.listModules(account);
        return level1Modules;
    }



}
