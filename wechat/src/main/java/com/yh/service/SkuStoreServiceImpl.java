package com.yh.service;

import com.yh.domain.SkuStore;
import com.yh.mapper.SkuStoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class SkuStoreServiceImpl implements SkuStoreService {
    @Resource(name = "skuStoreMapper")
    SkuStoreMapper skuStoreMapper;
    @Override
    public List<Map<String, String>> selectSkuOrderByCreateTime() {
        return skuStoreMapper.selectSkuOrderByCreateTime();
    }

    @Override
    public List<Map<String, String>> selectSkuRush() {
        return skuStoreMapper.selectSkuRush();
    }

    @Override
    public Map<String, String> selectSkuDetail(int skuId) {
        return skuStoreMapper.selectSkuDetail(skuId);
    }

    @Override
    public List<Map<String, String>> selectSkuScrollImg(int skuId) {
        return skuStoreMapper.selectSkuScrollImg(skuId);
    }

    @Override
    public List<Map<String, String>> selectSkuByProductId(int productId) {
        return skuStoreMapper.selectSkuByProductId(productId);
    }

    @Override
    public SkuStore selectSku(int skuId) {
        return skuStoreMapper.selectSkuBySkuId(skuId);
    }
}
