package com.secondhandcar.platform.model;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 高配属性项目
 * Created by xiet on 2017/10/17.
 */
@Data
public class SecondHandCarHighlightConfigItem extends Model<SecondHandCarHighlightConfigItem> implements Serializable {

    private Integer id;

    private String carId;

    private String title;

    private String image;

    private boolean isAdd;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}

