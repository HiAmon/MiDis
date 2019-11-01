package com.amon.wfx.merchant.goods.dao;

import com.amon.wfx.merchant.goods.pojos.Good;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GoodDAOTest {

    @Test
    void insertGood() {
//        Good good = new Good();
        System.out.println( (Math.random()*10000+10000+"").substring(6));
    }
}