package com.yh.service;

import com.yh.domain.Goodsmiddle;
public interface GoodsmiddleService{


    int deleteByPrimaryKey(Integer id);

    int insert(Goodsmiddle record);

    int insertSelective(Goodsmiddle record);

    Goodsmiddle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodsmiddle record);

    int updateByPrimaryKey(Goodsmiddle record);

}
