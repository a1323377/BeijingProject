package com.yh.service;

import com.yh.domain.QrCode;

public interface QRCodeService {
    QrCode selectQrCodeByWxId(Integer wxId);
    int insertNewQrCode(QrCode qrCode);
    int updateQrCode(QrCode qrCode);
}
