package com.amon.wfx.manager.goods.controller;

import com.amon.wfx.manager.goods.service.impl.GoodsService;
import com.amon.wfx.manager.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("goods/list")
    @ResponseBody
    public PageUtil listGoodsByPage(Integer pageNum){
       return goodsService.listGoodsByPage(pageNum);
    }
}
