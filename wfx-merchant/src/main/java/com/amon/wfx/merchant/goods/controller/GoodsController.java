package com.amon.wfx.merchant.goods.controller;

import com.amon.wfx.merchant.goods.pojos.Good;
import com.amon.wfx.merchant.goods.service.impl.GoodService;
import com.amon.wfx.merchant.utils.FtpJSch;
import com.amon.wfx.merchant.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.net.ftp.impl.FtpClient;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GoodsController {
    @Autowired
    GoodService goodService;

    @RequestMapping("goods/add")
    public String index(){
        return "goods_add";
    }


    @RequestMapping("goods/addGood")
    @ResponseBody
    public Map<String,String> addGood(@RequestBody Good good){
        Map<String,String> map = new HashMap<>();
        try {
            goodService.insertGood(good);
            map.put("code","1");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","0");
        }
        return map;
    }

    @RequestMapping("goods/upload")
    @ResponseBody
    public HashMap<String,Object> upload(MultipartFile multipartFile){
        HashMap<String,Object> map = new HashMap<>();
        File file= null;
        String filename = "";
        try {
            file = File.createTempFile("localhost-", ".jpg");
            filename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(file);

            FtpJSch ftpJSch = new FtpJSch();
            FtpJSch.getConnect();
            ftpJSch.upload(file,filename);

            map.put("code","1");
            map.put("msg","http://47.97.41.73/images/"+filename);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","0");
            map.put("msg","#");
        }
        return map;
    }



    @RequestMapping("goods/list")
    @ResponseBody
    public PageUtil goodsList(Integer pageNum){

        return goodService.listGoodsByCustomerId(pageNum);
    }


    @RequestMapping("goods/update")
    @ResponseBody
    public HashMap<String,String> updateGoods(String goodId,String goodName){
        HashMap<String,String> map = new HashMap<>();
        try {
            goodService.updateGoods(goodId,goodName);
            map.put("code","1");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","0");
        }
        return map;
    }

    @RequestMapping("goods/delete")
    @ResponseBody
    public HashMap<String,String> deleteGoods(String goodsId){
        HashMap<String,String> map = new HashMap<>();
        try {
            goodService.deleteGoods(goodsId);
            map.put("code","1");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","0");
        }
        return map;
    }

}
