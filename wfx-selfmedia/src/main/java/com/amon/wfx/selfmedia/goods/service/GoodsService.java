package com.amon.wfx.selfmedia.goods.service;

import com.amon.wfx.selfmedia.goods.dao.GoodsDAO;
import com.amon.wfx.selfmedia.goods.pojos.Goods;
import com.amon.wfx.selfmedia.utils.PageUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDAO goodsDAO;

    /**
     *
     * @return PageUtil
     */
    public PageUtil listGoodsSplitPage(Integer pageNum){
        PageUtil pageUtil = new PageUtil();
        /*
        当前页码pageNum
        limit:页面记录数PageUtil.PAGE_SIZE
        start:pageCount = counts/
        url:下一页数据的请求路径
         */
        Integer counts = goodsDAO.countAll();
        int pageCount = counts/PageUtil.PAGE_SIZE==0?(counts/PageUtil.PAGE_SIZE):(counts/PageUtil.PAGE_SIZE+1);
        int start = (pageNum-1)*PageUtil.PAGE_SIZE;
        int pn = pageNum+1;  //拿到下一页的页码
        List<Goods> goods = goodsDAO.listAllGoodsSplitPage(start,PageUtil.PAGE_SIZE);
        String baseUrl = "http://localhost:9999/goods/list?pageNum=";

        pageUtil.setData(goods);
        pageUtil.setPageCount(pageCount);
        pageUtil.setPageNum(pageNum);
        pageUtil.setUrl(baseUrl+pn);
        return pageUtil;

    }

    public List<Goods> listGoodsAll(){
        List<Goods> goods = new ArrayList<>();
        return goodsDAO.listAllGoods();
    }


    public Goods queryGoodsById(String goodsId){
        return goodsDAO.queryGoodsWithSkuById(goodsId);
    }


    @Autowired
    SolrClient solrClient;

    public PageUtil listBySearch(String kw, Integer pageNum){
        PageUtil pageUtil = new PageUtil();
        int pageSize = PageUtil.PAGE_SIZE;
        int start = (pageNum-1) * pageSize;
        SolrDocumentList results = null;
        try {
            SolrQuery solrQuery = new SolrQuery("goodName:"+kw);
            solrQuery.setRows(pageSize);
            solrQuery.setStart(start);

            QueryResponse queryResponse = solrClient.query(solrQuery);
            results = queryResponse.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int counts = goodsDAO.countAll();
        int pageCount = counts/pageSize==0?counts/pageSize:(counts/pageSize+1);
        pageUtil.setData(results);
        pageUtil.setPageNum(pageNum);
        pageUtil.setPageCount(pageCount);
        pageUtil.setUrl("#");
        return pageUtil;
    }

}
