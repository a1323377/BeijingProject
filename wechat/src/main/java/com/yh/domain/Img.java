package com.yh.domain;

<<<<<<< HEAD
=======
import javax.persistence.Id;

>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
public class Img {
    /**
    * 表id
    */
<<<<<<< HEAD
=======
    @Id
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
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
<<<<<<< HEAD
    * sku_store表的id
=======
    * 商品id
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
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