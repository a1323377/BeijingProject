package com.yh.service;

import com.yh.domain.SkuStore;
<<<<<<< HEAD
public interface SkuStoreService{


    int deleteByPrimaryKey(Integer id);

    int insert(SkuStore record);

    int insertSelective(SkuStore record);

    SkuStore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkuStore record);

    int updateByPrimaryKey(SkuStore record);

=======

import java.util.List;
import java.util.Map;

public interface SkuStoreService {
    List<Map<String,String>> selectSkuOrderByCreateTime();
    List<Map<String,String>> selectSkuRush();
    Map<String,String> selectSkuDetail(int skuId);
    List<Map<String,String>> selectSkuScrollImg(int skuId);
    List<Map<String,String>> selectSkuByProductId(int productId);
    SkuStore selectSku(int skuId);
>>>>>>> 7c693f6cafa87bf71c7972c784d59491b780f54d
}
