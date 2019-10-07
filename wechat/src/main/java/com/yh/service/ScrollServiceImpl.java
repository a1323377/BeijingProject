package com.yh.service;

import com.yh.domain.Scroll;
import com.yh.mapper.ScrollMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScrollServiceImpl implements ScrollService {
    @Resource(name = "scrollMapper")
    ScrollMapper scrollMapper;
    @Override
    public List<Scroll> selectScrollOrderByCreateTime() {
        return scrollMapper.selectScrollOrderByCreateTime();
    }
}
