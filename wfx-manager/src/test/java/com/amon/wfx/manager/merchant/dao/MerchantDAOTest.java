package com.amon.wfx.manager.merchant.dao;

import com.amon.wfx.manager.WfxManagerApplication;
import com.amon.wfx.manager.urp.dao.ModuleDAO;
import com.amon.wfx.manager.urp.dao.RoleDAO;
import com.amon.wfx.manager.urp.service.impl.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WfxManagerApplication.class)
public class MerchantDAOTest {
    @Autowired
    MerchantDAO merchantDAO;

    @Test
    public void test1(){
        System.out.println(merchantDAO.listAllMerchants());
    }

    @Test
    public void test2(){
//        System.out.println(String.valueOf(Math.random()).substring(2,8));

    }

}