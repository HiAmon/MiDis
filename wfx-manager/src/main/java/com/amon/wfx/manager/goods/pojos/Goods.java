package com.amon.wfx.manager.goods.pojos;

import com.amon.wfx.manager.merchant.pojos.Merchant;

import java.util.Date;
import java.util.List;

public class Goods {
    private String goodsId;  //商品Id
    private String goodsName;    //商品名称
    private Merchant merchant;  //商户Id
    private String goodPic;       //商品图片
    private Integer orderNo;    //排序编号
    private String typeId;      //商品分类
    private String tags;        //商品标签
    private Integer state;       //审核状态【0:待审核  1:已上架  2:已下架】
    private Date createTime;    //商品置顶时间
    private List<Sku> skus;     //套餐类型
    private Integer toped;      //置顶【0:取消置顶  1:置顶】
    private Integer recomed;    //推荐【0:否  1:是】
    private Date topedtime;     //置顶时间
    private Date recomedTime;   //推荐时间
    private String website;     //产品网址


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getToped() {
        return toped;
    }

    public void setToped(Integer toped) {
        this.toped = toped;
    }

    public Integer getRecomed() {
        return recomed;
    }

    public void setRecomed(Integer recomed) {
        this.recomed = recomed;
    }

    public Date getTopedtime() {
        return topedtime;
    }

    public void setTopedtime(Date topedtime) {
        this.topedtime = topedtime;
    }

    public Date getRecomedTime() {
        return recomedTime;
    }

    public void setRecomedTime(Date recomedTime) {
        this.recomedTime = recomedTime;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public String getGoodPic() {
        return goodPic;
    }

    public void setGoodPic(String goodPic) {
        this.goodPic = goodPic;
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

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", merchant=" + merchant +
                ", goodPic='" + goodPic + '\'' +
                ", orderNo=" + orderNo +
                ", typeId='" + typeId + '\'' +
                ", tags='" + tags + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", skus=" + skus +
                ", toped=" + toped +
                ", recomed=" + recomed +
                ", topedtime=" + topedtime +
                ", recomedTime=" + recomedTime +
                ", website='" + website + '\'' +
                '}';
    }
}


