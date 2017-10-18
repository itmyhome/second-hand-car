package com.secondhandcar.platform.model;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 检测详细项目
 * Created by xiet on 2017/10/17.
 */
@Data
public class SecondHandCarEvaluateItems extends Model<SecondHandCarEvaluateItems> {

    private Integer id;

    private String carId;

    private String title;

    private Integer count;

    private Integer faile;

    private String url;

    private String icon;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
