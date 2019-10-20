package com.yh.service;

import com.yh.domain.Secondtype;

import java.util.List;

public interface SecondtypeService{


    int deleteByPrimaryKey(Integer id);

    int insert(Secondtype record);

    int insertSelective(Secondtype record);

    Secondtype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Secondtype record);

    int updateByPrimaryKey(Secondtype record);

    /**
     * 查询所有二级类目信息
     * @return
     */
    List<Secondtype> selectAllSecondType();

    /**
     * 根据一级类目id查询对应的所有二级类目下的内容，用于分类展示时展示对应的二级类目
     * @param firstTypeId
     * @return
     */
    List<Secondtype> selectAllSecondTypeByFirstTypeId(Integer firstTypeId);

}
