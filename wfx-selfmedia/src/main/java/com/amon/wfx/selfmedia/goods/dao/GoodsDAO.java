package com.amon.wfx.selfmedia.goods.dao;

import com.amon.wfx.selfmedia.goods.pojos.Goods;
import com.amon.wfx.selfmedia.goods.pojos.Sku;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDAO {

    //按照【关键词】搜索商品并分页,这个是用【Solr】做！！！
//    List<Goods> listGoodsSplitPageByKeyWord(@Param("keyword") String keyword, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    //默认搜索【所有】商品并分页，可以用Redis做！
    List<Goods> listAllGoodsSplitPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    //查询所有记录...暂时【弃用】
    List<Goods> listAllGoods();

    //查询表中记录【总条数】
    Integer countAll();

    Goods queryGoodsById(String goodsId);

    List<Sku> listSkuByGoodId(String goodId);

    Goods queryGoodsWithSkuById(String goodId);

}
