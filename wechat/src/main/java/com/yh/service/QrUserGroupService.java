package com.yh.service;

import com.yh.domain.QrUserGroup;

public interface QrUserGroupService {
    int insertQrUserGroup(QrUserGroup qrUserGroup);
    QrUserGroup selectQrUserGroupByQrId(int qrId);
    QrUserGroup selectByQrIdAndWxId(int qrId, int wxId);
}
