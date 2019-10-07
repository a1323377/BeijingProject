package com.yh.domain;

import javax.persistence.Id;

public class Scroll {
    /**
    * 表id
    */
    @Id
    private Integer id;

    /**
    * 首页轮播图id
    */
    private Integer scrollId;

    /**
    * 首页轮播图图片
    */
    private String scrollImg;

    /**
    * 首页轮播图跳转地址
    */
    private String scrollSrc;

    /**
    * 首页轮播图启用状态：0启用；-1禁用
    */
    private Integer scrollStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScrollId() {
        return scrollId;
    }

    public void setScrollId(Integer scrollId) {
        this.scrollId = scrollId;
    }

    public String getScrollImg() {
        return scrollImg;
    }

    public void setScrollImg(String scrollImg) {
        this.scrollImg = scrollImg;
    }

    public String getScrollSrc() {
        return scrollSrc;
    }

    public void setScrollSrc(String scrollSrc) {
        this.scrollSrc = scrollSrc;
    }

    public Integer getScrollStatus() {
        return scrollStatus;
    }

    public void setScrollStatus(Integer scrollStatus) {
        this.scrollStatus = scrollStatus;
    }
}