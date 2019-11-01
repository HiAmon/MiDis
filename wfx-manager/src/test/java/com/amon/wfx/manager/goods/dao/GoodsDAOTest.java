package com.amon.wfx.manager.goods.dao;

import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsDAOTest {
    @Autowired
    GoodsDAO goodsDAO;

    @Test
    public void countAll() {
        System.out.println(goodsDAO.countAll());
    }


    @Test
    public void listGoodsSplitPage() {
        System.out.println(goodsDAO.listGoodsSplitPage(0,5));
    }


    @Test
    public void listGoodsSplitPageByType() {
        System.out.println(goodsDAO.listGoodsSplitPageByType(0,5,"01"));
    }



}