package com.secondhandcar.core.utils;

/**
 * Created by xiet on 2017/10/10.
 */
public class ReturnResult {

    protected int code;
    protected String message;

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

    public ReturnResult(){
        this.code = 200;
        this.message = "操作成功";
    }
}
