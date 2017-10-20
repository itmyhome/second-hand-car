package com.secondhandcar.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 二手车
 * Created by xiet on 2017/10/13.
 */
@Data
public class SecondHandCarResponseDTO implements Serializable{

    /**
     * 车辆标题
     */
    private String title;

    /**
     * 上牌日期
     */
    private Date licenseDate;

    /**
     * 行驶里程
     */
    private String roadHaul;

    /**
     * 缩略图
     */
    private String thumbImg;

    /**
     * 总价
     */
    private String price;

    /**
     * 首付
     */
    private String firstPay;

    /**
     * 是否新上架
     */
    private String newPost;

    /**
     * 热门属性
     */
    private List<SecondHandCarHotParamResponseDTO> hotParams;

}
