package com.yh.service;

import com.yh.domain.Standardvalue;
public interface StandardvalueService{


    int deleteByPrimaryKey(Integer id);

    int insert(Standardvalue record);

    int insertSelective(Standardvalue record);

    Standardvalue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standardvalue record);

    int updateByPrimaryKey(Standardvalue record);

}
