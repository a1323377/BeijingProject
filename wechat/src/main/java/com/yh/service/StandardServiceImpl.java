package com.yh.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yh.domain.Standard;
import com.yh.mapper.StandardMapper;
import com.yh.service.StandardService;
@Service
public class StandardServiceImpl implements StandardService{

    @Resource
    private StandardMapper standardMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return standardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Standard record) {
        return standardMapper.insert(record);
    }

    @Override
    public int insertSelective(Standard record) {
        return standardMapper.insertSelective(record);
    }

    @Override
    public Standard selectByPrimaryKey(Integer id) {
        return standardMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Standard record) {
        return standardMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Standard record) {
        return standardMapper.updateByPrimaryKey(record);
    }

}
