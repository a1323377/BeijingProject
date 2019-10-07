package com.yh.mapper;

import com.yh.domain.Standardvalue;

public interface StandardvalueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standardvalue record);

    int insertSelective(Standardvalue record);

    Standardvalue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standardvalue record);

    int updateByPrimaryKey(Standardvalue record);
}