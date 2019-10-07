package com.yh.mapper;

import com.yh.domain.Standardvalue;
<<<<<<< HEAD

=======
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
public interface StandardvalueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standardvalue record);

    int insertSelective(Standardvalue record);

    Standardvalue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standardvalue record);

    int updateByPrimaryKey(Standardvalue record);
<<<<<<< HEAD
=======

    List<Map<String,String>> selectStandardValueByProductId(int productId);
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
}