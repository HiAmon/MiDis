package com.amon.wfx.manager.merchant.serviceImpl;

import com.amon.wfx.manager.merchant.dao.MerchantDAO;
import com.amon.wfx.manager.merchant.iservice.IMerchantService;
import com.amon.wfx.manager.merchant.pojos.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MerchantService implements IMerchantService {
    @Autowired
    MerchantDAO merchantDAO;

    public List<Merchant> listAllMerchants(){
        return merchantDAO.listAllMerchants();
    }

    public void addMerchant(Merchant merchant){
        /*
            customerId,
            customerName,
            QQ,
            wxh,
            phone,createtime,
            loginName,
            loginPwd,
            state,
            level,
            accBalance,
            updateTime,
            website,
         */


        merchant.setCustomerId( "QF" + String.valueOf(Math.random()).substring(2,8));
        merchant.setCreatetime(new Date());
        merchant.setUpdateTime(new Date());
        merchant.setAccBalance(0.0);

        merchantDAO.addMerchant(merchant);
    }

    public Merchant queryForUpdateByCid(String customerId){
        return merchantDAO.queryForUpdateByCid(customerId);
    }

    public void updateMerchant(Merchant merchant){
        Merchant oldMerchant = merchantDAO.queryForUpdateByCid(merchant.getCustomerId());
        merchant.setCreatetime(oldMerchant.getCreatetime());
        merchant.setUpdateTime(new Date());
        merchant.setAccBalance(oldMerchant.getAccBalance());
        merchantDAO.updateMerchant(merchant);
    }

    public void unableMerchantByCid(String[] customerIds){
        for (int i = 0;i<customerIds.length;i++){
            merchantDAO.updateUnabledStateByCid(customerIds[i]);
        }
    }

    public void enableMerchantByCid(String[] customerIds){
        for (int i = 0;i<customerIds.length;i++){
            merchantDAO.updateEnabledStateByCid(customerIds[i]);
        }
    }
}
