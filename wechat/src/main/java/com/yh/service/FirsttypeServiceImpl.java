package com.yh.service;

import com.yh.domain.Firsttype;
import com.yh.mapper.FirsttypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FirsttypeServiceImpl implements FirsttypeService{

    @Resource
    private FirsttypeMapper firsttypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return firsttypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Firsttype record) {
        return firsttypeMapper.insert(record);
    }

    @Override
    public int insertSelective(Firsttype record) {
        return firsttypeMapper.insertSelective(record);
    }

    @Override
    public Firsttype selectByPrimaryKey(Integer id) {
        return firsttypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Firsttype record) {
        return firsttypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Firsttype record) {
        return firsttypeMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询所有一级类目
     * @return
     */
    @Override
    public List<Firsttype> selectAllFirstType() {
        return firsttypeMapper.selectAllFirstType();
    }

}
