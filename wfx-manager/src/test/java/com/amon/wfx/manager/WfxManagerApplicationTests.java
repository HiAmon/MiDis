package com.amon.wfx.manager;

import com.amon.wfx.manager.urp.dao.ModuleDAO;
import com.amon.wfx.manager.urp.dao.RoleDAO;
import com.amon.wfx.manager.urp.pojos.Level1Module;
import com.amon.wfx.manager.urp.pojos.Level2Module;
import com.amon.wfx.manager.urp.pojos.Level3Module;
import com.amon.wfx.manager.urp.pojos.Role;
import com.amon.wfx.manager.urp.service.impl.RoleService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WfxManagerApplication.class)
public class WfxManagerApplicationTests {
    @Autowired
    ModuleDAO moduleDAO;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    RoleService roleService;

    @Test
    public void testListModules() {
        List<Level1Module> level1Modules = moduleDAO.listModules("admin");
        for (Level1Module level1Module: level1Modules) {
            System.out.println(level1Module.getModuleCode());
            List<Level2Module> level2Modules = level1Module.getNodes();

            for (Level2Module level2Module: level2Modules) {
                System.out.println("\t"+level2Module.getModuleCode());
                List<Level3Module> level3Modules = level2Module.getNodes();

                for (Level2Module level3Module: level2Modules) {
                    System.out.println("\t\t"+level3Module.getModuleCode());
                }
            }
        }
    }

    @Test
    public void testListRole(){
        List<Role> roles = roleDAO.listRoles();
        for (Role role:roles) {
            System.out.println(role);
        }

    }

    @Test
    public void testlistModuleCodeByRoleId(){
        List<Level1Module> listGrantedModules = roleService.listGrantedModules("92122707");
        System.out.println(new Gson().toJson(listGrantedModules));
    }

    @Test
    public void testGrantModule(){
        roleDAO.unGrantModule("92122707","01010601");
    }

    @Test
    public void testGrantModuleService(){
        roleService.grantModule("92122707","01010601","0");
    }

    @Test
    public void test111(){
        System.out.println("12346789".substring(0,6));
    }

    @Test
    public void testGrant(){
        roleDAO.unGrantModule("92122707","010102");
    }
}
