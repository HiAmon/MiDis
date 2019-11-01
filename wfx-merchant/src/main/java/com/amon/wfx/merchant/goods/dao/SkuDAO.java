package com.amon.wfx.merchant.goods.dao;

import com.amon.wfx.merchant.goods.pojos.Sku;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuDAO {
    public void insertSku(Sku sku);

}
