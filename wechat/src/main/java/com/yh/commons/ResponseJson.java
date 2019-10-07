package com.yh.commons;

public class ResponseJson {
    private int  code;
    private Object data;
    private String msg;

    public ResponseJson(){}
    public ResponseJson(int code,  String msg,Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
