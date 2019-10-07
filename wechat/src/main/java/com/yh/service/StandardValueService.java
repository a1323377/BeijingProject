package com.yh.service;

import java.util.List;
import java.util.Map;

public interface StandardValueService {
    List<Map<String,String>> selectStandardValueByProductId(int productId);
}
