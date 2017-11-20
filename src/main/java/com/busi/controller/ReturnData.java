package com.busi.controller;

/**
 * 响应实体对象
 * Created by zzy on 2017/8/21.
 */
public class ReturnData {
    private String errorMsg;
    private String errorCode;
    private Object data;

    public ReturnData(String errorMsg, String errorCode, Object data) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
        this.data = data;
    }

    public ReturnData(){}

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
