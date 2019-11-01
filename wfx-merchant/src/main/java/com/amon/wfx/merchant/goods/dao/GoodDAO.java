package com.amon.wfx.merchant.goods.dao;

import com.amon.wfx.merchant.goods.pojos.Good;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodDAO {

    void insertGood(Good good);

    List<Good> listAll();

    List<Good> listGoodsByCustomerId(@Param("start") Integer start, @Param("pageSize") Integer pageSize, @Param("customerId") String customerId);


    void updateGood(@Param("goodId") String goodId,@Param("goodName") String goodName);

    void deleteGoods(String goodId);



}
