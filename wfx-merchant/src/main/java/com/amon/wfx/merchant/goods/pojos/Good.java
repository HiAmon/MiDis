package com.amon.wfx.merchant.goods.pojos;

import java.util.Date;
import java.util.List;

public class Good {
    private String goodId;  //商品Id
    private String goodName;    //商品名称
    private String customerId;  //商户Id
    private String goodPic1;
    private String goodPic2;
    private String goodPic3;
    private String promoteDesc;
    private String copyIds;     //文案Id
    private String copyDesc;    //文案说明
    private String forwardLink; //文案跳转链接
    private Integer orderNo;    //排序编号
    private String typeId;      //商品分类
    private String tags;        //商品标签
    private Integer state;
    private Date createTime;    //商品置顶时间
    private String spcId;   //站内文案
    private String zonId;   //空间文案
    private Integer sellNum;    //购买人数作弊值
    private String website;     //产品网址
    private List<Sku> skus;





    @Override
    public String toString() {
        return "Good{" +
                "goodId='" + goodId + '\'' +
                ", goodName='" + goodName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", goodPic1='" + goodPic1 + '\'' +
                ", goodPic2='" + goodPic2 + '\'' +
                ", goodPic3='" + goodPic3 + '\'' +
                ", promoteDesc='" + promoteDesc + '\'' +
                ", copyIds='" + copyIds + '\'' +
                ", copyDesc='" + copyDesc + '\'' +
                ", forwardLink='" + forwardLink + '\'' +
                ", orderNo=" + orderNo +
                ", typeId='" + typeId + '\'' +
                ", tags='" + tags + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", spcId='" + spcId + '\'' +
                ", zonId='" + zonId + '\'' +
                ", sellNum=" + sellNum +
                ", website='" + website + '\'' +
                ", skus=" + skus +
                '}';
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getGoodPic3() {
        return goodPic3;
    }

    public void setGoodPic3(String goodPic3) {
        this.goodPic3 = goodPic3;
    }

    public String getPromoteDesc() {
        return promoteDesc;
    }

    public void setPromoteDesc(String promoteDesc) {
        this.promoteDesc = promoteDesc;
    }

    public String getCopyIds() {
        return copyIds;
    }

    public void setCopyIds(String copyIds) {
        this.copyIds = copyIds;
    }

    public String getCopyDesc() {
        return copyDesc;
    }

    public void setCopyDesc(String copyDesc) {
        this.copyDesc = copyDesc;
    }

    public String getForwardLink() {
        return forwardLink;
    }

    public void setForwardLink(String forwardLink) {
        this.forwardLink = forwardLink;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSpcId() {
        return spcId;
    }

    public void setSpcId(String spcId) {
        this.spcId = spcId;
    }

    public String getZonId() {
        return zonId;
    }

    public void setZonId(String zonId) {
        this.zonId = zonId;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }
}


