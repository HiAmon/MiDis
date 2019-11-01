package com.amon.wfx.merchant.utils;


import com.amon.wfx.merchant.customer.dao.CustomerDAO;
import com.amon.wfx.merchant.customer.pojos.Customer;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    CustomerDAO customerDAO;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Customer customer = (Customer)principalCollection.iterator().next();
        String account = customer.getLoginName();

        Set<String> roleCodes = new HashSet<>();
        roleCodes.add("seller");

        Set<String> permissions = new HashSet<>();
        permissions.add("sell");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleCodes);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String account = token.getUsername();
        String password = new String(token.getPassword());


        Customer customer = customerDAO.queryCustomerByName(account);
        if(customer == null){
            throw new UnknownAccountException("帐号不存在！");
        }else{
            //用户存在则验证密码
            String md5Pwd = new SimpleHash("MD5",password).toHex();
            if( !customer.getLoginPwd().equals(md5Pwd)){
                throw new IncorrectCredentialsException("密码错误！");
            }
        }
        return new SimpleAuthenticationInfo(customer,password,getName());
    }
}
