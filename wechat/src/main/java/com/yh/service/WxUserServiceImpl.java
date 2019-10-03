package com.yh.service;

import com.yh.domain.WxUser;
import com.yh.mapper.WxUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WxUserServiceImpl implements WxUserService {
    @Resource(name="wxUserMapper")
    WxUserMapper wxUserMapper;
    @Override
    public int insertNewUser(WxUser wxUser) {
        return wxUserMapper.insertSelective(wxUser);
    }

    @Override
    public int updateUser(WxUser wxUser) {
        return wxUserMapper.updateUser(wxUser);
    }

    @Override
    public WxUser selectUserByOpenId(String openId) {
        return wxUserMapper.selectUserByOpenId(openId);
    }
}
