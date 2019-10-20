package com.yh.commons;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

public class MyConfig implements WXPayConfig {
    //正式公众号APPID
    public static final String APPID = "wxc37f01894579f97b";

    //正式公众号APPSECRET
    public static final String APPSECRET = "608e717800f24e7bf961718a234a1c67";

    //正式公众号MCHID
    public static final String MCHID = "1519853611";

    //正式公众号KEY
    public static final String KEY = "qwertyuiopasdfghjklzxcvbnm123456";

    @Override
    public String getAppID() {
        return APPID;
    }

    @Override
    public String getMchID() {
        return MCHID;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 0;
    }
}
