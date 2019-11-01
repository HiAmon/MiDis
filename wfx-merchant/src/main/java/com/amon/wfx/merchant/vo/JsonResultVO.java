package com.amon.wfx.merchant.vo;

public class JsonResultVO {
    private int code;
    private String msg;

    @Override
    public String toString() {
        return "JsonResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonResultVO() {
    }

    public JsonResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
