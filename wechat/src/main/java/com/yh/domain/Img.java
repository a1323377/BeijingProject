package com.yh.domain;

public class Img {
    /**
    * 表id
    */
    private Integer id;

    /**
    * 图片状态：-1禁用；0启用
    */
    private Integer imgStatus;

    /**
    * 轮播图图片
    */
    private String imgSrc;

    /**
    * sku_store表的id
    */
    private Integer imgProductid;

    /**
    * 商品图片类型：0封面图片；1轮播图片
    */
    private Integer imgType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(Integer imgStatus) {
        this.imgStatus = imgStatus;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Integer getImgProductid() {
        return imgProductid;
    }

    public void setImgProductid(Integer imgProductid) {
        this.imgProductid = imgProductid;
    }

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }
}