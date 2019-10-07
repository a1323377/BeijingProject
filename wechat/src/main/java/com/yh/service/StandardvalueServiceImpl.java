package com.yh.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yh.domain.Standardvalue;
import com.yh.mapper.StandardvalueMapper;
import com.yh.service.StandardvalueService;
@Service
public class StandardvalueServiceImpl implements StandardvalueService{

    @Resource
    private StandardvalueMapper standardvalueMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return standardvalueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Standardvalue record) {
        return standardvalueMapper.insert(record);
    }

    @Override
    public int insertSelective(Standardvalue record) {
        return standardvalueMapper.insertSelective(record);
    }

    @Override
    public Standardvalue selectByPrimaryKey(Integer id) {
        return standardvalueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Standardvalue record) {
        return standardvalueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Standardvalue record) {
        return standardvalueMapper.updateByPrimaryKey(record);
    }

}
