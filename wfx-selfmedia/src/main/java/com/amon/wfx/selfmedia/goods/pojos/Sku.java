package com.amon.wfx.selfmedia.goods.pojos;

public class Sku {
    private String skuId;       //套餐主键
    private String skuName;     //套餐名称
    private String skuCost;     //成本
    private String skuPrice;    //价格
    private String skuPmoney;   //分成
    private String goodId;      //商品ID
    private Integer orderNo;    //排序
    private String serviceMoney;//客服提成

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuCost() {
        return skuCost;
    }

    public void setSkuCost(String skuCost) {
        this.skuCost = skuCost;
    }

    public String getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(String skuPrice) {
        this.skuPrice = skuPrice;
    }

    public String getSkuPmoney() {
        return skuPmoney;
    }

    public void setSkuPmoney(String skuPmoney) {
        this.skuPmoney = skuPmoney;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getServiceMoney() {
        return serviceMoney;
    }

    public void setServiceMoney(String serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "skuId='" + skuId + '\'' +
                ", skuName='" + skuName + '\'' +
                ", skuCost='" + skuCost + '\'' +
                ", skuPrice='" + skuPrice + '\'' +
                ", skuPmoney='" + skuPmoney + '\'' +
                ", goodId='" + goodId + '\'' +
                ", orderNo=" + orderNo +
                ", serviceMoney='" + serviceMoney + '\'' +
                '}';
    }
}
