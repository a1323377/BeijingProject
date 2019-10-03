package com.yh.mapper;

import com.yh.domain.QrUserGroup;

public interface QrUserGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrUserGroup record);

    int insertSelective(QrUserGroup record);

    QrUserGroup selectByQrId(Integer qrId);

    int updateByPrimaryKeySelective(QrUserGroup record);

    int updateByPrimaryKey(QrUserGroup record);

    QrUserGroup selectByQrIdAndWxId(int qrId,int wxId);
}