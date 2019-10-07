package com.yh.mapper;

import com.yh.domain.Img;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}