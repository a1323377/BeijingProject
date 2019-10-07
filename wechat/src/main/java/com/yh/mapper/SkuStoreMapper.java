package com.yh.mapper;

import com.yh.domain.SkuStore;
<<<<<<< HEAD

=======
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
public interface SkuStoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkuStore record);

    int insertSelective(SkuStore record);

    SkuStore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkuStore record);

    int updateByPrimaryKey(SkuStore record);
<<<<<<< HEAD
=======

    List<Map<String,String>> selectSkuOrderByCreateTime();

    List<Map<String,String>> selectSkuRush();

    Map<String,String> selectSkuDetail(int skuId);

    List<Map<String,String>> selectSkuScrollImg(int skuId);

    List<Map<String,String>> selectSkuByProductId(int productId);

    SkuStore selectSkuBySkuId(int skuId);
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
}