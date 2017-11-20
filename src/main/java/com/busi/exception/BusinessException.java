package com.busi.exception;

/**
 * 自定义异常
 * Created by zzy on 2017/8/17.
 */
public class BusinessException extends RuntimeException{
    public BusinessException() {
        super();
    }
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message+":"+cause.getMessage(), cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
