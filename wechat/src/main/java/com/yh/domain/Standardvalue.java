package com.yh.domain;

import java.util.Date;

public class Standardvalue {
    /**
    * 表id
    */
    private Integer id;

    /**
    * 商品id
    */
    private Integer svProductid;

    /**
    * 规格id
    */
    private Integer svStandardid;

    /**
    * 创建时间
    */
    private Date svCreatetime;

    /**
    * 修改时间
    */
    private Date svUpdatetime;

    /**
    * 状态
    */
    private Integer svStatus;

    /**
    * 规格值
    */
    private String svStandardvalue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSvProductid() {
        return svProductid;
    }

    public void setSvProductid(Integer svProductid) {
        this.svProductid = svProductid;
    }

    public Integer getSvStandardid() {
        return svStandardid;
    }

    public void setSvStandardid(Integer svStandardid) {
        this.svStandardid = svStandardid;
    }

    public Date getSvCreatetime() {
        return svCreatetime;
    }

    public void setSvCreatetime(Date svCreatetime) {
        this.svCreatetime = svCreatetime;
    }

    public Date getSvUpdatetime() {
        return svUpdatetime;
    }

    public void setSvUpdatetime(Date svUpdatetime) {
        this.svUpdatetime = svUpdatetime;
    }

    public Integer getSvStatus() {
        return svStatus;
    }

    public void setSvStatus(Integer svStatus) {
        this.svStatus = svStatus;
    }

    public String getSvStandardvalue() {
        return svStandardvalue;
    }

    public void setSvStandardvalue(String svStandardvalue) {
        this.svStandardvalue = svStandardvalue;
    }
}