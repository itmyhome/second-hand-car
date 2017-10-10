package com.secondhandcar.admin.common.exception;

import com.secondhandcar.admin.common.enums.BizExceptionEnum;

/**
 * Created by xiet on 2017/10/10.
 */
public class BussinessException extends SecondHandCarException {

    public BussinessException(BizExceptionEnum bizExceptionEnum) {
        super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
    }
}
