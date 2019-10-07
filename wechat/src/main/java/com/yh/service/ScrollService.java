package com.yh.service;

import com.yh.domain.Scroll;

import java.util.List;

public interface ScrollService {
    List<Scroll> selectScrollOrderByCreateTime();
}
