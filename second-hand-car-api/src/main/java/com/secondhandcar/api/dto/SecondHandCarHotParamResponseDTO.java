package com.secondhandcar.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 二手车热门属性
 * Created by xiet on 2017/10/13.
 */
@Data
public class SecondHandCarHotParamResponseDTO  implements Serializable{

    /**
     * 热门属性文本
     */
    private String text;

    /**
     * 热门属性颜色
     */
    private String color;

}
