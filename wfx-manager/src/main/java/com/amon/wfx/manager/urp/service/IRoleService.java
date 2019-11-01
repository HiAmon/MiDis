package com.amon.wfx.manager.urp.service;

import com.amon.wfx.manager.urp.pojos.Level1Module;
import com.amon.wfx.manager.urp.pojos.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> listRoles();

    public List<Level1Module> listGrantedModules(String roleId);

    public void grantModule(String roleId,String moduleCode);
}
