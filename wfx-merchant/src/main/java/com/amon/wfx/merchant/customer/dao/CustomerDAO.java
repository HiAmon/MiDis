package com.amon.wfx.merchant.customer.dao;

import com.amon.wfx.merchant.customer.pojos.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO {

    Customer queryCustomerByName(String loginName);
}
