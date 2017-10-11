package com.secondhandcar.admin.common.enums;

/**
 * Created by xiet on 2017/10/11.
 */
public enum MenuStatusEnum {
    ENABLE(1, "启用"),
    DISABLE(0, "禁用");

    int code;
    String message;

    MenuStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
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

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            for (MenuStatusEnum s : MenuStatusEnum.values()) {
                if (s.getCode() == status) {
                    return s.getMessage();
                }
            }
            return "";
        }
    }
}
