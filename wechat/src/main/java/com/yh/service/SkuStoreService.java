package com.yh.service;

import com.yh.domain.SkuStore;

import java.util.List;
import java.util.Map;

public interface SkuStoreService {
    List<Map<String,String>> selectSkuOrderByCreateTime();
    List<Map<String,String>> selectSkuRush();
    Map<String,String> selectSkuDetail(int skuId);
    List<Map<String,String>> selectSkuScrollImg(int skuId);
    List<Map<String,String>> selectSkuByProductId(int productId);
    SkuStore selectSku(int skuId);
}
