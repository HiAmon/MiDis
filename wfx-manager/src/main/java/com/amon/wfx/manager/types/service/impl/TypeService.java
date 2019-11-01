package com.amon.wfx.manager.types.service.impl;

import com.amon.wfx.manager.types.dao.TypeDAO;
import com.amon.wfx.manager.types.pojos.GType;
import com.amon.wfx.manager.types.service.ITypeService;
import com.amon.wfx.manager.types.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private TypeDAO typeDAO;

    public List<TypeVO> listTypes(){
        List<GType> types = typeDAO.listTypes();
        List<TypeVO> typeVOs = new ArrayList<>();
        for (GType type: types) {
            typeVOs.add(new TypeVO(type));
        }
        return typeVOs;
    }
}
