package com.yh.domain;

public class Brand {
    /**
    * 表id
    */
    private Integer id;

    /**
    * 品牌名字
    */
    private String brandName;

    /**
    * 品牌logo
    */
    private String brandLogo;

    /**
    * 品牌描述
    */
    private String brandDescription;

    /**
    * 国别
    */
    private String brandNation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public String getBrandNation() {
        return brandNation;
    }

    public void setBrandNation(String brandNation) {
        this.brandNation = brandNation;
    }
}