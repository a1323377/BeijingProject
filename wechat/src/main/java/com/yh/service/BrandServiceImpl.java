package com.yh.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yh.domain.Brand;
import com.yh.mapper.BrandMapper;
import com.yh.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{

    @Resource
    private BrandMapper brandMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Brand record) {
        return brandMapper.insert(record);
    }

    @Override
    public int insertSelective(Brand record) {
        return brandMapper.insertSelective(record);
    }

    @Override
    public Brand selectByPrimaryKey(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Brand record) {
        return brandMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Brand record) {
        return brandMapper.updateByPrimaryKey(record);
    }

}
