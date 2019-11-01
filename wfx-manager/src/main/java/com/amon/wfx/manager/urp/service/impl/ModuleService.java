package com.amon.wfx.manager.urp.service.impl;

import com.amon.wfx.manager.urp.dao.ModuleDAO;
import com.amon.wfx.manager.urp.pojos.Level1Module;
import com.amon.wfx.manager.urp.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService implements IModuleService {

    @Autowired
    ModuleDAO moduleDAO;

    public List<Level1Module> listModules(String account){
        return moduleDAO.listModules(account);
    }
}
