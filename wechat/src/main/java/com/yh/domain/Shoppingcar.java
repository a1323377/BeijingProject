package com.yh.domain;

public class Shoppingcar {
    /**
    * 表id
    */
    private Integer id;

    /**
    * 商品id
    */
    private Integer carProductid;

    /**
    * 商品数量
    */
    private Integer carNum;


    /**
    * 用户id
    */
    private Integer carUserid;

    /**
    * 商品规格
    */
    private String carStandard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarProductid() {
        return carProductid;
    }

    public void setCarProductid(Integer carProductid) {
        this.carProductid = carProductid;
    }

    public Integer getCarNum() {
        return carNum;
    }

    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    public Integer getCarUserid() {
        return carUserid;
    }

    public void setCarUserid(Integer carUserid) {
        this.carUserid = carUserid;
    }

    public String getCarStandard() {
        return carStandard;
    }

    public void setCarStandard(String carStandard) {
        this.carStandard = carStandard;
    }
}