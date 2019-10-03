package com.yh.mapper;

import com.yh.domain.MessageGroup;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageGroup record);

    int insertSelective(MessageGroup record);

    MessageGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageGroup record);

    int updateByPrimaryKey(MessageGroup record);
}