package com.yh.service;

import com.yh.domain.Img;
public interface ImgService{


    int deleteByPrimaryKey(Integer id);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);

}
