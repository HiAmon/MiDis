package com.amon.wfx.manager.urp.dao;

import com.amon.wfx.manager.urp.pojos.Level1Module;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ModuleDAO {

    public List<Level1Module> listModules(@Param("account") String account);

    public Set<String> listModuleCodesByUserAccount(@Param("account") String account);
}
