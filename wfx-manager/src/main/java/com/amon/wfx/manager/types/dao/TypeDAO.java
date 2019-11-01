package com.amon.wfx.manager.types.dao;

import com.amon.wfx.manager.types.pojos.GType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDAO {

    public List<GType> listTypes();
}
