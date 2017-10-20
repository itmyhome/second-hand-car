package com.secondhandcar.api.model;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 检测详细项目
 * Created by xiet on 2017/10/17.
 */
@Data
public class SecondHandCarEvaluateItem extends Model<SecondHandCarEvaluateItem> {

    private Integer id;
    /**
     * 二手车表中的carId
     */
    private String carId;
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

    private Date createTime;

    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
