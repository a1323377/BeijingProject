package com.yh.service;

import com.yh.domain.Shoppingcar;

import java.util.List;
import java.util.Map;

public interface ShoppingCarService {
    int insertShoppingCar(Shoppingcar shoppingcar);
    List<Map<String,String>> getMyCar(int userId);
}
