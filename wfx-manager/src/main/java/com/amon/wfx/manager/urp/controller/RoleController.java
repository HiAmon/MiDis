package com.amon.wfx.manager.urp.controller;

import com.amon.wfx.manager.urp.pojos.Level1Module;
import com.amon.wfx.manager.urp.pojos.Role;
import com.amon.wfx.manager.urp.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;


    @RequestMapping("/list")
    @ResponseBody
    public List<Role> showRoleList(){
        return roleService.listRoles();
    }


    /*
    此方法用于获取当前角色拥有的权限树
     */
    @RequestMapping("/roleModules")
    @ResponseBody
    public List<Level1Module> listGrantedModules(String roleId){
        List<Level1Module> level1Modules = roleService.listGrantedModules(roleId);
        return level1Modules;
    }

    @RequestMapping("/grant")
    @ResponseBody
    public List<Level1Module> grantOn(String roleId,String moCode, String grantOpt){
        return roleService.grantModule(roleId,moCode,grantOpt);
    }

}
