package com.yh.mapper;

import com.yh.domain.QrCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QrCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrCode record);

    int insertSelective(QrCode record);

    QrCode selectByWxId(Integer wxId);

    int updateByWxIdSelective(QrCode record);

    int updateByPrimaryKey(QrCode record);
}