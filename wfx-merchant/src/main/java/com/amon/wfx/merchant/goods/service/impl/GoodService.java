package com.amon.wfx.merchant.goods.service.impl;

import com.amon.wfx.merchant.customer.pojos.Customer;
import com.amon.wfx.merchant.goods.dao.GoodDAO;
import com.amon.wfx.merchant.goods.pojos.Good;
import com.amon.wfx.merchant.goods.service.IGoodService;
import com.amon.wfx.merchant.utils.PageUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


@Service
public class GoodService implements IGoodService {
    @Autowired
    private GoodDAO goodDAO;
    @Autowired
    private StringRedisTemplate redisTemplate;


    public void insertGood(Good good) throws Exception{
        String goodsId ="qf"+ String.valueOf(Math.random()).substring(2);
        good.setGoodId(goodsId);
        goodDAO.insertGood(good);
    }



    public PageUtil listAllGoods(int pageNum){
        PageUtil pageUtil = new PageUtil();

        String goodslistStr = redisTemplate.boundValueOps("wfx-goodslist").get();
        if (goodslistStr == null){
            synchronized (this){
                goodslistStr = redisTemplate.boundValueOps("wfx-goodslist").get();
                if (goodslistStr == null){
                    goodslistStr = new Gson().toJson(goodDAO.listAll());
                    redisTemplate.boundValueOps("wfx-goodslist").set(goodslistStr);
                }
            }
        }
        List<Good> goodList = new Gson().fromJson(goodslistStr,new TypeToken<List<Good>>(){}.getType());
        pageUtil.setData(goodList);
        pageUtil.setPageNum(pageNum);
        int counts = goodList.size();
        int pageCount = counts/PageUtil.PAGE_SIZE==0?(counts/PageUtil.PAGE_SIZE):(counts/PageUtil.PAGE_SIZE+1);
        pageUtil.setPageCount(pageCount);
        pageUtil.setUrl("http://localhost:9090/goods/list?pageNum="+(pageNum+1));
        return pageUtil;
    }

    //start ==> pageNum
    public PageUtil listGoodsByCustomerId(int pageNum){
        PageUtil pageUtil = new PageUtil();
        int pageSize = PageUtil.PAGE_SIZE;
        Customer customer= (Customer) SecurityUtils.getSubject().getPrincipal();
        String customerId=customer.getCustomerId();
        String key=customerId+"-"+pageNum;
        int start=(pageNum-1)*pageSize;
        Type type =new TypeToken<List<Good>>(){}.getType();
        List<Good> goodsList=new Gson().fromJson(redisTemplate.boundValueOps("key").get(),type);

        if(goodsList==null){
            synchronized (this){
                goodsList=new Gson().fromJson(redisTemplate.boundValueOps("key").get(),type);
                if(goodsList==null){
                    goodsList=goodDAO.listGoodsByCustomerId(start, pageSize, customerId);
                    redisTemplate.boundValueOps(key).set(new Gson().toJson(goodsList),30000);
                }
            }
        }
        int counts = goodsList.size();
        int pageCount = counts/PageUtil.PAGE_SIZE==0?(counts/PageUtil.PAGE_SIZE):(counts/PageUtil.PAGE_SIZE+1);


        pageUtil.setData(goodsList);
        pageUtil.setPageNum(pageNum);
        pageUtil.setUrl("http://localhost:9090/goods/list?pageNum="+(pageNum+1));
        pageUtil.setPageCount(pageCount);
        return pageUtil;
    }


    public void updateGoods(String goodsId,String goodName) throws Exception{
        goodDAO.updateGood(goodsId,goodName);
    }


    public void deleteGoods(String goodsId) throws Exception{
            goodDAO.deleteGoods(goodsId);
        }






}
