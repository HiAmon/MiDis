package com.amon.wfx.merchant.goods.service.impl;

import com.amon.wfx.merchant.goods.dao.SkuDAO;
import com.amon.wfx.merchant.goods.pojos.Sku;
import com.amon.wfx.merchant.goods.service.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuService implements ISkuService {
    @Autowired
    private SkuDAO skuDAO;

    public void insertSku(Sku sku){
        skuDAO.insertSku(sku);
    }
}
