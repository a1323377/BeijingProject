package com.yh.domain;

<<<<<<< HEAD
=======
import javax.persistence.Id;
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
import java.util.Date;

public class SkuStore {
    /**
    * 表id
    */
<<<<<<< HEAD
=======
    @Id
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
    private Integer id;

    /**
    * 商品 id
    */
    private Integer skuProductid;

    /**
    * 中间表 id
    */
    private Integer skuMiddleid;

    /**
    * 商品颜色
    */
    private String skuColor;

    /**
    * 库存数量
    */
    private Integer skuNum;

    /**
    * 单价
    */
    private Integer skuPrice;

    /**
<<<<<<< HEAD
    * 状态：0：上架有货；-1下架；1缺货
=======
    * 状态
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
    */
    private Integer skuStatus;

    /**
    * 活动价
    */
    private Integer skuActiveprice;

    /**
    * 销售价
    */
    private Integer skuSaleprice;

    /**
    * 创建时间
    */
    private Date skuCreatetime;

    /**
    * 修改时间
    */
    private Date skuUpdatetime;

<<<<<<< HEAD
=======
    /**
    * 销售数量
    */
    private Integer skuSalecout;

>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSkuProductid() {
        return skuProductid;
    }

    public void setSkuProductid(Integer skuProductid) {
        this.skuProductid = skuProductid;
    }

    public Integer getSkuMiddleid() {
        return skuMiddleid;
    }

    public void setSkuMiddleid(Integer skuMiddleid) {
        this.skuMiddleid = skuMiddleid;
    }

    public String getSkuColor() {
        return skuColor;
    }

    public void setSkuColor(String skuColor) {
        this.skuColor = skuColor;
    }

    public Integer getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(Integer skuNum) {
        this.skuNum = skuNum;
    }

    public Integer getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Integer skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Integer getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(Integer skuStatus) {
        this.skuStatus = skuStatus;
    }

    public Integer getSkuActiveprice() {
        return skuActiveprice;
    }

    public void setSkuActiveprice(Integer skuActiveprice) {
        this.skuActiveprice = skuActiveprice;
    }

    public Integer getSkuSaleprice() {
        return skuSaleprice;
    }

    public void setSkuSaleprice(Integer skuSaleprice) {
        this.skuSaleprice = skuSaleprice;
    }

    public Date getSkuCreatetime() {
        return skuCreatetime;
    }

    public void setSkuCreatetime(Date skuCreatetime) {
        this.skuCreatetime = skuCreatetime;
    }

    public Date getSkuUpdatetime() {
        return skuUpdatetime;
    }

    public void setSkuUpdatetime(Date skuUpdatetime) {
        this.skuUpdatetime = skuUpdatetime;
    }
<<<<<<< HEAD
=======

    public Integer getSkuSalecout() {
        return skuSalecout;
    }

    public void setSkuSalecout(Integer skuSalecout) {
        this.skuSalecout = skuSalecout;
    }
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
}