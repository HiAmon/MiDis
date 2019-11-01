package com.amon.wfx.manager.merchant.controller;

import com.amon.wfx.manager.merchant.pojos.Merchant;
import com.amon.wfx.manager.merchant.serviceImpl.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @RequestMapping("/list")
    public String ShowMerchantList(Model model){
        List<Merchant> merchants = merchantService.listAllMerchants();
        model.addAttribute("mts",merchants);
        return "merchant-list";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addMerchant(Merchant merchant){
//        Merchant merchant = new Gson().fromJson(jsonString,Merchant.class);
        merchantService.addMerchant(merchant);
        return "ok";
    }

    @RequestMapping("/queryForUpdate")
    @ResponseBody
    public Merchant queryMerchantForUpdateByCid(String customerId){
            return merchantService.queryForUpdateByCid(customerId);
    }

    @RequestMapping("/updateMerchant")
    @ResponseBody
    public String updateMerchant(Merchant merchant){
        merchantService.updateMerchant(merchant);
        return "ok";
    }
    @RequestMapping("/unableMerchant")
    @ResponseBody
    public String unableMerchant(String[] customerIds){
        merchantService.unableMerchantByCid(customerIds);
        return "ok";
    }

    @RequestMapping("/enableMerchant")
    @ResponseBody
    public String enableMerchant(String[] customerIds){
        merchantService.enableMerchantByCid(customerIds);
        return "ok";
    }

//String customerId, String customerName,String QQ, String wxh,String phone, String loginName,String loginPwd, Integer state,Integer level, Double accBalance,String website
}
