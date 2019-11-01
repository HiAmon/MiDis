package com.amon.wfx.selfmedia.member.service.impl;

import com.amon.wfx.selfmedia.goods.service.GoodsService;
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
    public void listGoodsSplitPage() {
        System.out.println(goodsService.listGoodsSplitPage(1));
    }

    @Test
    public void listGoodsAll() {
    }

    @Test
    public void queryGoodsById() {
    }
}