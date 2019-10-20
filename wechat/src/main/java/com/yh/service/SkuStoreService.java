package com.yh.service;
import java.util.List;
import java.util.Map;
import com.yh.domain.SkuStore;
public interface SkuStoreService{

    int deleteByPrimaryKey(Integer id);

    int insert(SkuStore record);

    int insertSelective(SkuStore record);

    SkuStore selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkuStore record);

    int updateByPrimaryKey(SkuStore record);
    
    List<Map<String,String>> selectSkuOrderByCreateTime();
    
    List<Map<String,String>> selectSkuRush();
    
    Map<String,String> selectSkuDetail(int skuId);
    
    List<Map<String,String>> selectSkuScrollImg(int skuId);
    
    List<Map<String,String>> selectSkuByProductId(int productId);
    
    SkuStore selectSku(int skuId);
}
