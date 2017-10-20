package com.secondhandcar.api.model;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiet on 2017/10/14.
 */
@Data
public class SecondHandCarDetail extends Model<SecondHandCar> implements Serializable {


    private Integer id;
    /**
     * 二手车表中的carId
     */
    private String carId;
    /**
     *排放量
     */
    private String air_displacement;
    /**
     *变速箱类型
     */
    private String gearbox;
    /**
     *售卖者
     */
    private String seller;
    /**
     *售卖者职业
     */
    private String seller_job;
    /**
     *过户次数
     */
    private String transfer_num;
    /**
     *车牌所在地
     */
    private String card_city;
    /**
     *所在区名
     */
    private String district_name;
    /**
     *卖家描述
     */
    private String seller_description;
    /**
     *年检到期描述
     */
    private String audit_date;
    /**
     *交强险到期描述
     */
    private String strong_insurance_date;
    /**
     *商业险到期描述
     */
    private String insurance_date;
    /**
     *
     */
    private String deal_price;
    /**
     *
     */
    private String service_charge;

    /**
     * 新车价格
     */
    private String new_price;

    /**
     * 使用年限
     */
    private String use_date;

    /**
     * 关注人数
     */
    private String follow_num;

    /**
     * 排放标准
     */
    private String emission_standard;

    /**
     *排放标准提示
     */
    private String emission_standard_desc;
    /**
     *排放标准提示h5 url
     */
    private String emissions_standards_url;
    /**
     *高配属性项目
     */
    private List<SecondHandCarHighlightConfigItem> highlightConfigItem;
    /**
     *合格证图标
     */
    private String hege_icon;
    /**
     *检测描述
     */
    private String evaluator_desc;
    /**
     *检测详细项目
     */
    private List<SecondHandCarEvaluateItem> evaluateItem;
    /**
     *
     */
    private String service;
    /**
     *
     */
    private String service_desc;

    /**
     * 最高赔付额
     */
    private String compensation_amount;
    /**
     *
     */
    private String imageList;
    /**
     *
     */
    private String phone;
    /**
     *
     */
    private String imageCategoryList;


    @Override
    protected Serializable pkVal() {
        return id;
    }
}
