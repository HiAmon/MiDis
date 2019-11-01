package com.amon.wfx.manager.goods.service.impl;

import com.amon.wfx.manager.goods.dao.GoodsDAO;
import com.amon.wfx.manager.goods.pojos.Goods;
import com.amon.wfx.manager.goods.service.IGoodsService;
import com.amon.wfx.manager.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GoodsService implements IGoodsService {

    @Autowired
    private GoodsDAO goodsDAO;
//需要的数据：1.总记录数 ； 2.当前页码 ；3.当前页数据

    public HashMap<String,Object> listGoods(){
        //1.总记录数
        int count = goodsDAO.countAll();

        //2.当前页码
        int pageNum = count% PageUtil.PAGE_SIZE==0?count/PageUtil.PAGE_SIZE:count/PageUtil.PAGE_SIZE;

        //3.当前页数据
        return null;
    }

    public PageUtil listGoodsByPage(Integer pageNum){
        PageUtil pageUtil = new PageUtil();

        Integer counts = goodsDAO.countAll();
        int pageCount = counts/PageUtil.PAGE_SIZE==0?(counts/PageUtil.PAGE_SIZE):(counts/PageUtil.PAGE_SIZE+1);
        int start = (pageNum-1)*PageUtil.PAGE_SIZE;
        int pn = pageNum+1;  //拿到下一页的页码
        List<Goods> goods = goodsDAO.listGoodsSplitPage(start,PageUtil.PAGE_SIZE);
        String baseUrl = "http://localhost:8080/goods/list?pageNum=";

        pageUtil.setData(goods);
        pageUtil.setPageCount(pageCount);
        pageUtil.setPageNum(pageNum);
        pageUtil.setUrl(baseUrl+pn);
        return pageUtil;

    }
}
