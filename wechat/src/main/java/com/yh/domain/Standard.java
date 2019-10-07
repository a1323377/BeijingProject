package com.yh.domain;

import java.util.Date;

public class Standard {
    /**
    * 表id
    */
    private Integer id;

    /**
    * 规格名
    */
    private String standardName;

    /**
    * 规格类型
    */
    private Integer standardType;

    /**
    * 商品id
    */
    private Integer standardProductid;

    /**
    * 创建时间
    */
    private Date standardCreatetime;

    /**
    * 修改时间
    */
    private Date standardUpdatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public Integer getStandardType() {
        return standardType;
    }

    public void setStandardType(Integer standardType) {
        this.standardType = standardType;
    }

    public Integer getStandardProductid() {
        return standardProductid;
    }

    public void setStandardProductid(Integer standardProductid) {
        this.standardProductid = standardProductid;
    }

    public Date getStandardCreatetime() {
        return standardCreatetime;
    }

    public void setStandardCreatetime(Date standardCreatetime) {
        this.standardCreatetime = standardCreatetime;
    }

    public Date getStandardUpdatetime() {
        return standardUpdatetime;
    }

    public void setStandardUpdatetime(Date standardUpdatetime) {
        this.standardUpdatetime = standardUpdatetime;
    }
}