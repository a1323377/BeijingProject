package com.yh.mapper;

import com.yh.domain.Standard;
<<<<<<< HEAD

=======
import org.apache.ibatis.annotations.Mapper;

@Mapper
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
public interface StandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Standard record);

    int insertSelective(Standard record);

    Standard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}