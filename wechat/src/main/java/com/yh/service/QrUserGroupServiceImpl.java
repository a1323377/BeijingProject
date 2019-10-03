package com.yh.service;

import com.yh.domain.QrUserGroup;
import com.yh.mapper.QrUserGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QrUserGroupServiceImpl implements  QrUserGroupService {
    @Autowired
    QrUserGroupMapper qrUserGroupMapper;
    @Override
    public int insertQrUserGroup(QrUserGroup qrUserGroup) {
        return qrUserGroupMapper.insert(qrUserGroup);
    }

    @Override
    public QrUserGroup selectQrUserGroupByQrId(int qrId) {
        return qrUserGroupMapper.selectByQrId(qrId);
    }

    @Override
    public QrUserGroup selectByQrIdAndWxId(int qrId, int wxId) {
        return qrUserGroupMapper.selectByQrIdAndWxId(qrId,wxId);
    }
}
