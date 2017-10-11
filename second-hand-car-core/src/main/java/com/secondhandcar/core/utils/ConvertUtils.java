package com.secondhandcar.core.utils;


import com.secondhandcar.core.exception.ToolBoxException;

/**
 * Created by xiet on 2017/10/11.
 */
public class ConvertUtils {


    private ConvertUtils() {
        // 静态类不可实例化
    }


    /**
     * 转换为Integer数组<br>
     *
     * @param isIgnoreConvertError 是否忽略转换错误，忽略则给值null
     * @param values 被转换的值
     * @return 结果
     */
    public static Integer[] toIntArray(boolean isIgnoreConvertError, Object... values) {

        if (CollectionUtils.isEmpty(values)) {
            return new Integer[] {};
        }
        final Integer[] ints = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            final Integer v = toInt(values[i], null);
            if (null == v && isIgnoreConvertError == false) {
                throw new ToolBoxException(StringUtils.format("Convert [{}] to Integer error!", values[i]));
            }
            ints[i] = v;
        }
        return ints;
    }


    /**
     * 转换为Integer数组<br>
     *
     * @param split 被转换的值
     * @return 结果
     */
    public static Integer[] toIntArray(String str) {
        return toIntArray(",", str);
    }

    /**
     * 转换为Integer数组<br>
     *
     * @param split 分隔符
     * @param split 被转换的值
     * @return 结果
     */
    public static Integer[] toIntArray(String split, String str) {
        if (StringUtils.isEmpty(str)) {
            return new Integer[] {};
        }
        String[] arr = str.split(split);
        final Integer[] ints = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            final Integer v = toInt(arr[i], 0);
            ints[i] = v;
        }
        return ints;
    }

    /**
     * 转换为String数组<br>
     *
     * @param split 被转换的值
     * @return 结果
     */
    public static String[] toStrArray(String str) {
        return toStrArray("", str);
    }

    /**
     * 转换为String数组<br>
     *
     * @param split 分隔符
     * @param split 被转换的值
     * @return 结果
     */
    public static String[] toStrArray(String split, String str) {
        return str.split(split);
    }

    /**
     * 转换为int<br>
     * 如果给定的值为空，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     *
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static Integer toInt(Object value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        final String valueStr = toStr(value, null);
        if (StringUtils.isBlank(valueStr)) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(valueStr.trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 转换为字符串<br>
     * 如果给定的值为null，或者转换失败，返回默认值<br>
     * 转换失败不会报错
     *
     * @param value 被转换的值
     * @param defaultValue 转换错误时的默认值
     * @return 结果
     */
    public static String toStr(Object value, String defaultValue) {
        if (null == value) {
            return defaultValue;
        }
        if (value instanceof String) {
            return (String) value;
        } else if (CollectionUtils.isArray(value)) {
            return CollectionUtils.toString(value);
        }
        return value.toString();
    }
}
