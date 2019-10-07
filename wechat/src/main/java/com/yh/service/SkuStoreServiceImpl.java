package com.yh.service;

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
}
