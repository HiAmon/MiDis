package com.amon.wfx.manager.urp.service.impl;

import com.amon.wfx.manager.urp.dao.UserDAO;
import com.amon.wfx.manager.urp.pojos.User;
import com.amon.wfx.manager.urp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    UserDAO userDAO;
    public List<User> listAllUsers(){
        return userDAO.listAllUsers();
    }

    public void unableUser(String userId){
        userDAO.updateUserUnabled(userId);
    }

    public void resetPasswd(String userId){
        userDAO.updateUserPasswd(userId);
    }
}
