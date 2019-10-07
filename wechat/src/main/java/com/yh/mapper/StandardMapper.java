package com.yh.mapper;

import com.yh.domain.Standard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}