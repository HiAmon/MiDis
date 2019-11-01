package com.amon.wfx.selfmedia.goods.pojos;

import java.util.List;

public class Goods {

    private String id;
    private String goodName;
    private String goodPic;
    private String goodPic1;
    private String goodPic2;
    private String tags;
    private String promoteDesc;

    private String customerId;
    private String customerName;
    private String level;
    private String customerQQ;
    private List<Sku> skus;

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public String getGoodPic1() {
        return goodPic1;
    }

    public void setGoodPic1(String goodPic1) {
        this.goodPic1 = goodPic1;
    }

    public String getGoodPic2() {
        return goodPic2;
    }

    public void setGoodPic2(String goodPic2) {
        this.goodPic2 = goodPic2;
    }

    public String getCustomerQQ() {
        return customerQQ;
    }

    public void setCustomerQQ(String customerQQ) {
        this.customerQQ = customerQQ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodPic() {
        return goodPic;
    }

    public void setGoodPic(String goodPic) {
        this.goodPic = goodPic;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPromoteDesc() {
        return promoteDesc;
    }

    public void setPromoteDesc(String promoteDesc) {
        this.promoteDesc = promoteDesc;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }



}
