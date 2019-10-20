package com.yh.service;

import com.yh.mapper.StandardvalueMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class StandardValueServiceImpl implements StandardValueService {
    @Resource(name = "standardvalueMapper")
    StandardvalueMapper standardvalueMapper;
    @Override
    public List<Map<String, String>> selectStandardValueByProductId(int productId) {
        return standardvalueMapper.selectStandardValueByProductId(productId);
    }
}
