package com.amon.wfx.manager.urp.service;

import com.amon.wfx.manager.urp.pojos.Level1Module;

import java.util.List;

public interface IModuleService {
    public List<Level1Module> listModules(String account);
}
