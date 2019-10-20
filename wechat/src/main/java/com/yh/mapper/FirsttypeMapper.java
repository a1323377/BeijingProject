package com.yh.mapper;

import com.yh.domain.Firsttype;

import java.util.List;

public interface FirsttypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Firsttype record);

    int insertSelective(Firsttype record);

    Firsttype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Firsttype record);

    int updateByPrimaryKey(Firsttype record);

    /**
     * 查询所有一级类目
     * @return
     */
    List<Firsttype> selectAllFirstType();

}