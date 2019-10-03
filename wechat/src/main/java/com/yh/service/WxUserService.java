package com.yh.service;

import com.yh.domain.WxUser;

public interface WxUserService {
    int insertNewUser(WxUser wxUser);
    int updateUser(WxUser wxUser);
    WxUser selectUserByOpenId(String openId);
}
