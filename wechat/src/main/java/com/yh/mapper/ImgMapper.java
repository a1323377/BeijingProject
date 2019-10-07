package com.yh.mapper;

import com.yh.domain.Img;
<<<<<<< HEAD

=======
import org.apache.ibatis.annotations.Mapper;

@Mapper
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
public interface ImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}