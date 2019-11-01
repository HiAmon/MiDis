package com.amon.wfx.manager.urp.service.impl;

import com.amon.wfx.manager.urp.dao.ModuleDAO;
import com.amon.wfx.manager.urp.dao.RoleDAO;
import com.amon.wfx.manager.urp.pojos.Level1Module;
import com.amon.wfx.manager.urp.pojos.Level2Module;
import com.amon.wfx.manager.urp.pojos.Level3Module;
import com.amon.wfx.manager.urp.pojos.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    ModuleDAO moduleDAO;

    public List<Role> listRoles(){
        return roleDAO.listRoles();
    }

    /*
    此方法用于在树中勾选当前用户拥有的权限
    1. 先查出所有权限构成权限树结构
    2. 查出当前用户具有的所有权限编码
    3. 依层遍历权限树，将树中对应编码的节点state添加checked属性
     */
    public List<Level1Module> listGrantedModules(String roleId) {
        //这里的admin是因为一开始要先查询所有的权限，然后再去选中
        List<Level1Module> level1Modules = moduleDAO.listModules("admin");

        //根据当前角色id去查询
        List<String> grantedCodes = roleDAO.listModuleCodeByRoleId(roleId);

        //遍历功能树中每一级的每一个菜单
        for (int i = 0; i < level1Modules.size(); i++) {
            Level1Module level1Module = level1Modules.get(i);
            if (grantedCodes.contains(level1Module.getModuleCode())) {
                level1Module.getState().put("checked", true);
            }
            for (int j = 0; j < level1Module.getNodes().size(); j++) {
                Level2Module level2Module = level1Module.getNodes().get(j);
                if (grantedCodes.contains(level2Module.getModuleCode())) {
                    level2Module.getState().put("checked", true);
                }
                for (int k = 0; k < level2Module.getNodes().size(); k++) {
                    Level3Module level3Module = level2Module.getNodes().get(k);
                    if (grantedCodes.contains(level3Module.getModuleCode())) {
                        level3Module.getState().put("checked", true);
                    }
                }
            }
        }
        return level1Modules;
    }





    //分级授权
    /*
    业务需求：
        【递归授权，针对多级权限可扩展】
        1. 当用户选中当前权限并授权
            1.1 将当前父级权限的所有子权限授权  （给孩子们授权）
            1.2 查看当前权限是几级权限，是否有父级权限
            1.3 查看当前父级权限的父级权限是否授权  （给爸爸授权）
        2. 当用户取消当前权限
            2.1 查看当前权限是否具有子权限
            2.2 取消当前权限的所有子权限  （取消孩子们）
            2.3 查看当前权限是否具有父权限
            2.4 判断当前权限的父级权限是否具有已勾选的子级权限（判断还有没有兄弟姐妹）
                2.4.1 有，则不操作
                2.4.2 没有，则取消当前权限的父权限  （取消爸爸）

     */
    public List<Level1Module> grantModule(String roleId,String moduleCode,String grantOpt) {
        if ("1".equals(grantOpt)) {
            roleDAO.grantModule(roleId,moduleCode);
            grantParent(roleId, moduleCode);
            grantChild(roleId, moduleCode);
        }else if ("0".equals(grantOpt)){
            roleDAO.unGrantModule(roleId,moduleCode);
            unGrantChild(roleId, moduleCode);
            unGrantParent(roleId, moduleCode);
        }
        return listGrantedModules(roleId);
    }

    //递归父级授权
    public void grantParent(String roleId,String moduleCode){
        String parentModuleCode = roleDAO.listParentModuleCodeByChild(moduleCode);
        roleDAO.grantModule(roleId,parentModuleCode);
        if (moduleCode != null && "01".equals(parentModuleCode)){
            grantParent(roleId,parentModuleCode);
        }
    }

    //递归取消父级权限（先查询）
    public void  unGrantParent(String roleId,String moduleCode){
        String parentModuleCode = roleDAO.listParentModuleCodeByChild(moduleCode);
        List<String> survivChilds = roleDAO.listChildModuleCodesByParentWithRoleId(roleId, parentModuleCode);
        if(survivChilds.size() == 0){
            roleDAO.unGrantModule(roleId,parentModuleCode);
        }
    }

    //递归子级授权
    public void grantChild(String roleId,String moduleCode){
        List<String> childs = roleDAO.listChildModuleCodesByParent(moduleCode);
        for (String childmc : childs){
            roleDAO.grantModule(roleId,childmc);
            if (childmc != null && roleDAO.listChildModuleCodesByParent(childmc) != null){
                grantChild(roleId,childmc);
            }
        }

    }

    //递归取消子级权限
    public void unGrantChild(String roleId,String moduleCode){
        List<String> childs = roleDAO.listChildModuleCodesByParent(moduleCode);
        for (String childmc : childs){
            roleDAO.unGrantModule(roleId,childmc);
            if (childmc != null && roleDAO.listChildModuleCodesByParent(childmc) != null){
                unGrantChild(roleId,childmc);
            }
        }
    }









}