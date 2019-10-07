package com.yh.domain;

import java.util.Date;

public class Product {
    /**
    * 表id
    */
    private Integer id;

    /**
    * 商品名称
    */
    private String productName;

    /**
    * 商品展示图
    */
    private String productCover;

    /**
    * 商品状态：-1下架；0上架；1抢购中；2折扣中
    */
    private Integer productStatus;

    /**
    * 商品所属类目
    */
    private Integer productTypeid;

    /**
    * 商品添加时间
    */
    private Date productCreatetime;

    /**
    * 商品品牌id
    */
    private Integer productBrandid;

    /**
    * 商品更新时间
    */
    private Date productUpdatetime;


    private String src;

    private Integer price;

    private Integer num;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCover() {
        return productCover;
    }

    public void setProductCover(String productCover) {
        this.productCover = productCover;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(Integer productTypeid) {
        this.productTypeid = productTypeid;
    }

    public Date getProductCreatetime() {
        return productCreatetime;
    }

    public void setProductCreatetime(Date productCreatetime) {
        this.productCreatetime = productCreatetime;
    }

    public Integer getProductBrandid() {
        return productBrandid;
    }

    public void setProductBrandid(Integer productBrandid) {
        this.productBrandid = productBrandid;
    }

    public Date getProductUpdatetime() {
        return productUpdatetime;
    }

    public void setProductUpdatetime(Date productUpdatetime) {
        this.productUpdatetime = productUpdatetime;
    }



    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}