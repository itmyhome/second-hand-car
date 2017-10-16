package com.secondhandcar.api.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 二手车热门属性
 * Created by xiet on 2017/10/13.
 */
@Data
public class SecondHandCarHotParam extends Model<SecondHandCarHotParam> implements Serializable{
    /**
     * 主键id
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;

    /**
     * 二手车表中的cardId
     */
    private String cardId;

    /**
     * 热门属性文本
     */
    private String text;

    /**
     * 热门属性颜色
     */
    private String color;

    private Date createTime;

    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
