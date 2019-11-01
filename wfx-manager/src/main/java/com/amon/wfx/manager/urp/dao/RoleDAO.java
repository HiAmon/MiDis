package com.amon.wfx.manager.urp.dao;

import com.amon.wfx.manager.urp.pojos.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleDAO {

    public List<Role> listRoles();

    public List<String> listModuleCodeByRoleId(@Param("roleId") String roleid);

    public void grantModule(@Param("roleId") String roleId, @Param("moduleCode")String moduleCode);

    public void unGrantModule(@Param("roleId") String roleId,@Param("moduleCode")String moduleCode);

    public String listParentModuleCodeByChild(@Param("childModuleCode") String childModuleCode);

    public List<String> listChildModuleCodesByParent(@Param("parentModuleCode") String parentModuleCode);

    public List<String> listChildModuleCodesByParentWithRoleId(@Param("roleId") String roleId,@Param("parentModuleCode") String parentModuleCode);

    public Set<String> listRoleCodesByUserAccount(@Param("account") String account);

}
