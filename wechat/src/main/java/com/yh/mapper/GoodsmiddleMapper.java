package com.yh.mapper;

import com.yh.domain.Goodsmiddle;

public interface GoodsmiddleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goodsmiddle record);

    int insertSelective(Goodsmiddle record);

    Goodsmiddle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodsmiddle record);

    int updateByPrimaryKey(Goodsmiddle record);
}