package com.yh.domain;

public class Secondtype {
    /**
    * 表id
    */
    private Integer id;

    /**
    * 二级类目所属的一级类目id
    */
    private Integer secondFirstid;

    /**
    * 二级类目名称
    */
    private String secondName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSecondFirstid() {
        return secondFirstid;
    }

    public void setSecondFirstid(Integer secondFirstid) {
        this.secondFirstid = secondFirstid;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}