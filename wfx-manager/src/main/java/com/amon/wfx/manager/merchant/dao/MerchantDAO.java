package com.amon.wfx.manager.merchant.dao;

import com.amon.wfx.manager.merchant.pojos.Merchant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantDAO {

    public List<Merchant> listAllMerchants();

    public void addMerchant(Merchant merchant);

    public Merchant queryForUpdateByCid(String customerId);

    public void updateMerchant(Merchant merchant);

    public void updateUnabledStateByCid(String customerId);

    public void updateEnabledStateByCid(String customerId);
}
