package com.amon.wfx.manager.goods.dao;

import com.amon.wfx.manager.goods.pojos.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDAO {

    public int countAll();

    public int countByKeyWord(String kw);

    public List<Goods> listGoodsSplitPage(@Param("start") int start, @Param("pageSize") int pageSize);

    public List<Goods> listGoodsSplitPageByType(@Param("start") int start, @Param("pageSize") int pageSize, @Param("typeId") String typeId);
}
