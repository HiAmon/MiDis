package com.amon.wfx.manager.urp.dao;

import com.amon.wfx.manager.WfxManagerApplication;
import com.amon.wfx.manager.urp.service.impl.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WfxManagerApplication.class)
public class UserDAOTest {
    @Autowired
    ModuleDAO moduleDAO;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    RoleService roleService;

    @Test
    public void test1(){

    }

}