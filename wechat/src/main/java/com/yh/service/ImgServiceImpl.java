package com.yh.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yh.mapper.ImgMapper;
import com.yh.domain.Img;
import com.yh.service.ImgService;
@Service
public class ImgServiceImpl implements ImgService{

    @Resource
    private ImgMapper imgMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return imgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Img record) {
        return imgMapper.insert(record);
    }

    @Override
    public int insertSelective(Img record) {
        return imgMapper.insertSelective(record);
    }

    @Override
    public Img selectByPrimaryKey(Integer id) {
        return imgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Img record) {
        return imgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Img record) {
        return imgMapper.updateByPrimaryKey(record);
    }

}
