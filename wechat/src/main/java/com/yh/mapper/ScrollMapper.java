package com.yh.mapper;

import com.yh.domain.Scroll;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScrollMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scroll record);

    int insertSelective(Scroll record);

    Scroll selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scroll record);

    int updateByPrimaryKey(Scroll record);

    List<Scroll> selectScrollOrderByCreateTime();
}