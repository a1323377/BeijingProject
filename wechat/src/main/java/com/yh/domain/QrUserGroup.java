package com.yh.domain;

public class QrUserGroup {
    private Integer id;

    private Integer wxId;

    private Integer qrId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWxId() {
        return wxId;
    }

    public void setWxId(Integer wxId) {
        this.wxId = wxId;
    }

    public Integer getQrId() {
        return qrId;
    }

    public void setQrId(Integer qrId) {
        this.qrId = qrId;
    }

    @Override
    public String toString() {
        return "QrUserGroup{" +
                "id=" + id +
                ", wxId=" + wxId +
                ", qrId=" + qrId +
                '}';
    }
}