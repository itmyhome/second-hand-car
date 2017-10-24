package com.secondhandcar.api.dto;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 检测详细项目
 * Created by xiet on 2017/10/17.
 */
@Data
public class SecondHandCarEvaluateItemResponseDTO implements Serializable {

    /**
     * 检测项目名称
     */
    private String title;
    /**
     * 成功数量
     */
    private Integer count;
    /**
     * 失败数量
     */
    private Integer faile;
    /**
     * 对应详细检测h5 url
     */
    private String url;
    /**
     * 对应检测项目图标
     */
    private String icon;

}
