package com.secondhandcar.api.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 二手车
 * Created by xiet on 2017/10/13.
 */
@Data
@TableName("second_hand_car")
public class SecondHandCar extends Model<SecondHandCar> implements Serializable{
    /**
     * 主键id
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;


    /**
     * 车辆ID
     */
//    @TableField("car_id")
    private String carId;

    /**
     * 车辆标题
     */
    private String title;

    /**
     * 上牌日期
     */
    @DateTimeFormat(pattern = "yyyy-mm-dd")
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
    private transient String secondHandCarHotParamStr;

    /**
     * 版本（乐观锁保留字段）
     */
    private Integer version;
    /**
     * 排序
     */
    private Integer orderNo;
    private Date createTime;
    private Date updateTime;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
