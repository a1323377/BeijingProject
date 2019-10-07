package com.yh.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yh.mapper.GoodsmiddleMapper;
import com.yh.domain.Goodsmiddle;
import com.yh.service.GoodsmiddleService;
@Service
public class GoodsmiddleServiceImpl implements GoodsmiddleService{

    @Resource
    private GoodsmiddleMapper goodsmiddleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsmiddleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Goodsmiddle record) {
        return goodsmiddleMapper.insert(record);
    }

    @Override
    public int insertSelective(Goodsmiddle record) {
        return goodsmiddleMapper.insertSelective(record);
    }

    @Override
    public Goodsmiddle selectByPrimaryKey(Integer id) {
        return goodsmiddleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Goodsmiddle record) {
        return goodsmiddleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Goodsmiddle record) {
        return goodsmiddleMapper.updateByPrimaryKey(record);
    }

}
