package com.secondhandcar.admin.common.exception;

import com.secondhandcar.core.enums.SecondHandCarCoreExceptionEnum;

/**
 * Created by xiet on 2017/10/10.
 */
public class SecondHandCarException extends RuntimeException{

    /**
     * 错误码
     */
    protected int errCode;

    /**
     * 错误提示信息
     */
    protected String errMsg;

    /**
     * 业务异常跳转页面路径
     */
    protected String urlPath;

    protected SecondHandCarException(int errCode, String errMsg, String urlPath) {
        this.setValues(errCode, errMsg, urlPath);
    }

    public SecondHandCarException(SecondHandCarCoreExceptionEnum secondHandCarCoreExceptionEnum) {
        this.setValues(secondHandCarCoreExceptionEnum.getCode(), secondHandCarCoreExceptionEnum.getMessage(), secondHandCarCoreExceptionEnum.getUrlPath());
    }

    private void setValues(int friendlyCode, String friendlyMsg, String urlPath) {
        this.errCode = friendlyCode;
        this.errMsg = friendlyMsg;
        this.urlPath = urlPath;
    }

    public int getCode() {
        return errCode;
    }

    public void setCode(int code) {
        this.errCode = code;
    }

    public String getMessage() {
        return errMsg;
    }

    public void setMessage(String message) {
        this.errMsg = message;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }
}
