package com.yh.service;

import com.yh.domain.Secondtype;
import com.yh.mapper.SecondtypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SecondtypeServiceImpl implements SecondtypeService{

    @Resource
    private SecondtypeMapper secondtypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return secondtypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Secondtype record) {
        return secondtypeMapper.insert(record);
    }

    @Override
    public int insertSelective(Secondtype record) {
        return secondtypeMapper.insertSelective(record);
    }

    @Override
    public Secondtype selectByPrimaryKey(Integer id) {
        return secondtypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Secondtype record) {
        return secondtypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Secondtype record) {
        return secondtypeMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询所有二级类目信息
     * @return
     */
    @Override
    public List<Secondtype> selectAllSecondType() {
        return secondtypeMapper.selectAllSecondType();
    }

    /**
     * 根据一级类目id查询对应的所有二级类目下的内容，用于分类展示时展示对应的二级类目
     * @param firstTypeId
     * @return
     */
    @Override
    public List<Secondtype> selectAllSecondTypeByFirstTypeId(Integer firstTypeId) {
        return secondtypeMapper.selectAllSecondTypeByFirstTypeId(firstTypeId);
    }

}
