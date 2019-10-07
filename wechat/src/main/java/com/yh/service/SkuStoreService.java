package com.yh.service;

import java.util.List;
import java.util.Map;

public interface SkuStoreService {
    List<Map<String,String>> selectSkuOrderByCreateTime();
    List<Map<String,String>> selectSkuRush();
}
