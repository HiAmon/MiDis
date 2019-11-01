package com.amon.wfx.manager.goods.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTest {
    @Autowired
    GoodsService goodsService;



    @Test
    public void listGoods() {
        goodsService.listGoods();
    }

    @Test
    public void listGoodsByPage() {
        System.out.println(goodsService.listGoodsByPage(1));
    }
}