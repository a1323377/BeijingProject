package com.yh.mapper;

import com.yh.domain.WxUser;
import tk.mybatis.mapper.common.BaseMapper;
@org.apache.ibatis.annotations.Mapper
public interface WxUserMapper extends BaseMapper<WxUser> {
    int updateUser(WxUser wxUser);
    WxUser selectUserByOpenId(String openId);
}