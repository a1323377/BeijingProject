package com.yh.service;

import com.yh.domain.Shoppingcar;
import com.yh.mapper.ShoppingcarMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Resource(name="shoppingcarMapper")
    ShoppingcarMapper shoppingcarMapper;
    @Override
    public int insertShoppingCar(Shoppingcar shoppingcar) {
        return shoppingcarMapper.insertSelective(shoppingcar);
    }

    @Override
    public List<Map<String, String>> getMyCar(int userId) {
        return shoppingcarMapper.selectByUserId(userId);
    }
}
