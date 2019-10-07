package com.yh.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yh.mapper.SkuStoreMapper;
import com.yh.domain.SkuStore;
import com.yh.service.SkuStoreService;
@Service
public class SkuStoreServiceImpl implements SkuStoreService{

    @Resource
    private SkuStoreMapper skuStoreMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return skuStoreMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SkuStore record) {
        return skuStoreMapper.insert(record);
    }

    @Override
    public int insertSelective(SkuStore record) {
        return skuStoreMapper.insertSelective(record);
    }

    @Override
    public SkuStore selectByPrimaryKey(Integer id) {
        return skuStoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SkuStore record) {
        return skuStoreMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SkuStore record) {
        return skuStoreMapper.updateByPrimaryKey(record);
    }

}
