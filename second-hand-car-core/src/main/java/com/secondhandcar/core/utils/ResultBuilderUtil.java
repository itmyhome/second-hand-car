package com.secondhandcar.core.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiet on 2017/3/27.
 */
public class ResultBuilderUtil {

    private ResultBuilderUtil() {
    }

    /**
     * 只返回成功
     *
     * @return
     */
    public static ReturnResult success() {
        return new ReturnResult();
    }

    /**
     * 不带分页对象
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T extends Serializable> ReturnResult<T> success(T data) {
        ReturnResult<T> result = new ReturnResult();
        result.setData(data);
        return result;
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static Map<String, Object> success(Object data) {
        Map<String, Object> rc = new HashMap<String, Object>();
        rc.put("code", "000000");
        rc.put("message", "成功");
        if (data != null) {
            rc.put("data", data);
        }
        return rc;
    }

}
