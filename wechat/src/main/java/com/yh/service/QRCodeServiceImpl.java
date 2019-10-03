package com.yh.service;

import com.yh.domain.QrCode;
import com.yh.mapper.QrCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "qRCodeServiceImpl")
public class QRCodeServiceImpl implements  QRCodeService {
    @Autowired
    QrCodeMapper qrCodeMapper;
    @Override
    public QrCode selectQrCodeByWxId(Integer wxId) {
        return qrCodeMapper.selectByWxId(wxId);
    }

    @Override
    public int insertNewQrCode(QrCode qrCode) {
        return qrCodeMapper.insertSelective(qrCode);
    }

    @Override
    public int updateQrCode(QrCode qrCode) {
        return qrCodeMapper.updateByWxIdSelective(qrCode);
    }
}
