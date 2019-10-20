package com.yh.mapper;

import com.yh.domain.Shoppingcar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShoppingcarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shoppingcar record);

    int insertSelective(Shoppingcar record);

    Shoppingcar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shoppingcar record);

    int updateByPrimaryKey(Shoppingcar record);

    List<Map<String,String>> selectByUserId(int userId);
}