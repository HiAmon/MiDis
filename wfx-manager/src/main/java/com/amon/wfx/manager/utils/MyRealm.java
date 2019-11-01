package com.amon.wfx.manager.utils;

import com.amon.wfx.manager.urp.dao.ModuleDAO;
import com.amon.wfx.manager.urp.dao.RoleDAO;
import com.amon.wfx.manager.urp.dao.UserDAO;
import com.amon.wfx.manager.urp.pojos.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;
    @Autowired
    ModuleDAO moduleDAO;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User)principalCollection.iterator().next();
        String account = user.getAccount();

        //2.通过user的id查询当前用户的所有角色名 ---- Set<String>
        Set<String> roleCodes = roleDAO.listRoleCodesByUserAccount(account);

        //3.通过user的id查询当前用户的所有权限percode ---- Set<String>
        Set<String> permissions = moduleDAO.listModuleCodesByUserAccount(account);

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
        User user = userDAO.queryUserByAccount(account);
        if(user == null){
            throw new UnknownAccountException("帐号不存在！");
        }else{
            //用户存在则验证密码
            String md5Pwd = new SimpleHash("MD5",password).toHex();
            if( !user.getPassword().equals(md5Pwd)){
                throw new IncorrectCredentialsException("密码错误！");
            }
        }
        return new SimpleAuthenticationInfo(user,password,getName());
    }
}
