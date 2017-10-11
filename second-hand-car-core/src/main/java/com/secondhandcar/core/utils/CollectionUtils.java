package com.secondhandcar.core.utils;

import com.secondhandcar.core.exception.ToolBoxException;

import java.util.Arrays;

/**
 * Created by xiet on 2017/10/11.
 */
public class CollectionUtils {

    private CollectionUtils() {
        // 静态类不可实例化
    }
    /**
     * 数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判定给定对象是否为数组类型
     * @param obj 对象
     * @return 是否为数组类型
     */
    public static boolean isArray(Object obj){
        return obj.getClass().isArray();
    }

    /**
     * 数组或集合转String
     *
     * @param obj 集合或数组对象
     * @return 数组字符串，与集合转字符串格式相同
     */
    public static String toString(Object obj) {
        if (null == obj) {
            return null;
        }
        if (isArray(obj)) {
            try {
                return Arrays.deepToString((Object[]) obj);
            } catch (Exception e) {
                final String className = obj.getClass().getComponentType().getName();
                switch (className) {
                    case "long":
                        return Arrays.toString((long[]) obj);
                    case "int":
                        return Arrays.toString((int[]) obj);
                    case "short":
                        return Arrays.toString((short[]) obj);
                    case "char":
                        return Arrays.toString((char[]) obj);
                    case "byte":
                        return Arrays.toString((byte[]) obj);
                    case "boolean":
                        return Arrays.toString((boolean[]) obj);
                    case "float":
                        return Arrays.toString((float[]) obj);
                    case "double":
                        return Arrays.toString((double[]) obj);
                    default:
                        throw new ToolBoxException(e);
                }
            }
        }
        return obj.toString();
    }
}
