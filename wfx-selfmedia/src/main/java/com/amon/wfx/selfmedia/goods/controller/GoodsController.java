package com.amon.wfx.selfmedia.goods.controller;

import com.amon.wfx.selfmedia.goods.pojos.Goods;
import com.amon.wfx.selfmedia.goods.service.GoodsService;
import com.amon.wfx.selfmedia.utils.PageUtil;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsController {


    @Autowired
    GoodsService goodsService;

    @RequestMapping("goods/search")
    @ResponseBody
    public PageUtil search(String keyword,Integer pageNum){
        return goodsService.listBySearch(keyword,pageNum);
    }


    //分页查询
    @RequestMapping("goods/list")
    @ResponseBody
    public PageUtil list(Integer pageNum){
        //在service拿到pageUtil需要的所有数据，封装好返回给controller
        return goodsService.listGoodsSplitPage(pageNum);
    }



    @RequestMapping("goods/detail")
    public String detail(String goodsId,Model model){
        model.addAttribute("goods",goodsService.queryGoodsById(goodsId));
        return "goods-detail";
    }


//    @RequestMapping("goods/listPage")
//    public String listByPage(Model model){
//        //默认访问第一页
//        List<Goods> allgoods = goodsService.listGoodsAll();
//        model.addAttribute("goodslist",goodsService.listGoodsSplitPage(new PageUtil(0,allgoods.size())));
//        return "goods-list";
//    }

//    @RequestMapping("goods-detail.html")
//    public String goodsDetail(Model model,String goodsId){
//        Goods goods = goodsService.queryGoodsById(goodsId);
//        model.addAttribute("goods",goods);
//        return "goods-detail";
//    }

}
