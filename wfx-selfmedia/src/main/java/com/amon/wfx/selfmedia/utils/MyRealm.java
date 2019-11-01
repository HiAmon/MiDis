package com.amon.wfx.selfmedia.utils;


import com.amon.wfx.selfmedia.member.dao.MemberDAO;
import com.amon.wfx.selfmedia.member.pojos.Member;
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
    MemberDAO memberDAO;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Member member = (Member)principalCollection.iterator().next();
        String account = member.getAccount();

        Set<String> roleCodes = new HashSet<>();
        roleCodes.add("advertiser");

        Set<String> permissions = new HashSet<>();
        permissions.add("advertise");

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

        //2.根据用户名查询数据库（UserDAO）,得到一个User对象
        Member member = memberDAO.queryMemberByAccount(account);
        if(member == null){
            throw new UnknownAccountException("帐号不存在！");
        }else{
            //用户存在则验证密码
            String md5Pwd = new SimpleHash("MD5",password).toHex();
            if( !member.getPassword().equals(md5Pwd)){
                throw new IncorrectCredentialsException("密码错误！");
            }
        }
        return new SimpleAuthenticationInfo(member,password,getName());
    }
}
