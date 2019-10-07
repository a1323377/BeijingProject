package com.yh.mapper;

import com.yh.domain.Standardvalue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StandardvalueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standardvalue record);

    int insertSelective(Standardvalue record);

    Standardvalue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standardvalue record);

    int updateByPrimaryKey(Standardvalue record);

    List<Map<String,String>> selectStandardValueByProductId(int productId);
}