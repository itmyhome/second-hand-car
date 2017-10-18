package com.secondhandcar.core.utils;

import java.io.Serializable;

/**
 * Created by xiet on 2017/10/10.
 */
public class ReturnResult<T extends Serializable> {

    protected int code;
    protected String message;
    protected T data;

    public ReturnResult(){
        this.code = 200;
        this.message = "操作成功";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
