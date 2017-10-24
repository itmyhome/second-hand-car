package com.secondhandcar.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 高配属性项目
 * Created by xiet on 2017/10/17.
 */
@Data
public class SecondHandCarHighlightConfigItemResponseDTO implements Serializable {

    /**
     * 高配属性名称
     */
    private String title;
    /**
     * 高配属性图片地址
     */
    private String image;

}

