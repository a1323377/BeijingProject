package com.yh.domain;

import java.util.Date;

public class Goodsmiddle {
    /**
    * 表id
    */
    private Integer id;

    /**
    * 商品中间表-商品id
    */
    private Integer middleProductid;

    /**
    * 商品中间表-规格
    */
    private Integer middleStandard;

    /**
    * 规格值
    */
    private Integer middleStandardvalue;

    /**
    * 库存id
    */
    private Integer middleStoreid;

    /**
    * 创建时间
    */
    private Date middleCreatetime;

    /**
    * 状态：0：上架有货；-1下架；1缺货
    */
    private Integer middleStatus;

    /**
    * 修改时间
    */
    private Date middleUpdatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMiddleProductid() {
        return middleProductid;
    }

    public void setMiddleProductid(Integer middleProductid) {
        this.middleProductid = middleProductid;
    }

    public Integer getMiddleStandard() {
        return middleStandard;
    }

    public void setMiddleStandard(Integer middleStandard) {
        this.middleStandard = middleStandard;
    }

    public Integer getMiddleStandardvalue() {
        return middleStandardvalue;
    }

    public void setMiddleStandardvalue(Integer middleStandardvalue) {
        this.middleStandardvalue = middleStandardvalue;
    }

    public Integer getMiddleStoreid() {
        return middleStoreid;
    }

    public void setMiddleStoreid(Integer middleStoreid) {
        this.middleStoreid = middleStoreid;
    }

    public Date getMiddleCreatetime() {
        return middleCreatetime;
    }

    public void setMiddleCreatetime(Date middleCreatetime) {
        this.middleCreatetime = middleCreatetime;
    }

    public Integer getMiddleStatus() {
        return middleStatus;
    }

    public void setMiddleStatus(Integer middleStatus) {
        this.middleStatus = middleStatus;
    }

    public Date getMiddleUpdatetime() {
        return middleUpdatetime;
    }

    public void setMiddleUpdatetime(Date middleUpdatetime) {
        this.middleUpdatetime = middleUpdatetime;
    }
}