package com.yh.controller;

import com.yh.domain.Firsttype;
import com.yh.service.FirsttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirstTypeController {

    @Autowired
    FirsttypeService firsttypeService;

    /**
     * 查询所有一级类目
     * @return
     */
    @RequestMapping(value = "selectAllFirstType")
    public List<Firsttype> selectAllFirstType(){
        return firsttypeService.selectAllFirstType();
    }

}
