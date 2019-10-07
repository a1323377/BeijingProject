package com.yh.controller;

import com.yh.domain.Secondtype;
import com.yh.service.SecondtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecondTypeController {

    @Autowired
    SecondtypeService secondtypeService;

    /**
     * 查询所有二级类目信息
     * @return
     */
    @RequestMapping(value = "selectAllSecondType")
    public List<Secondtype> selectAllSecondType(){
        return secondtypeService.selectAllSecondType();
    }

    /**
     * 根据一级类目id查询对应的所有二级类目下的内容，用于分类展示时展示对应的二级类目
     * @param firstTypeId
     * @return
     */
    @RequestMapping(value = "selectAllSecondTypeByFirstTypeId")
    public List<Secondtype> selectAllSecondTypeByFirstTypeId(Integer firstTypeId){
        /*PageHelper.startPage(1,3);
        List<Secondtype> list = secondtypeService.selectAllSecondTypeByFirstTypeId(firstTypeId);
        PageInfo<Secondtype> pageInfo = new PageInfo<>(list);
        pageInfo.setPageNum(1);*/
        return secondtypeService.selectAllSecondTypeByFirstTypeId(firstTypeId);
    }

}
