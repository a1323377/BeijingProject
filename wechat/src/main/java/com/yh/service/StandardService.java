package com.yh.service;

import com.yh.domain.Standard;
public interface StandardService{


    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);

}
