package com.amon.wfx.manager.urp.dao;

import com.amon.wfx.manager.urp.pojos.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    public User queryUserByAccount(@Param("account") String account);

    public List<User> listAllUsers();

    public void updateUserUnabled(String userId);

    public void updateUserPasswd(String userId);
}
