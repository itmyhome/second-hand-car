package com.secondhandcar.platform.model;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 高配属性项目
 * Created by xiet on 2017/10/17.
 */
@Data
public class SecondHandCarHighlightConfigItem extends Model<SecondHandCarHighlightConfigItem> implements Serializable {

    private Integer id;
    /**
     * 二手车表中的carId
     */
    private String carId;
    /**
     * 高配属性名称
     */
    private String title;
    /**
     * 高配属性图片地址
     */
    private String image;
    /**
     * 是否是加装
     */
    private boolean isAdd;

    private Date createTime;

    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}

