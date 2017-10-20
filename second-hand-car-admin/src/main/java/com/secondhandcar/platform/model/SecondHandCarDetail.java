package com.secondhandcar.platform.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiet on 2017/10/14.
 */
@Data
public class SecondHandCarDetail extends Model<SecondHandCar> implements Serializable {


    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 二手车表中的carId
     */
    private String carId;
    /**
     * 排放量
     */
    private String airDisplacement;
    /**
     * 变速箱类型
     */
    private String gearbox;
    /**
     * 售卖者
     */
    private String seller;
    /**
     * 售卖者职业
     */
    private String sellerJob;
    /**
     * 过户次数
     */
    private String transferNum;
    /**
     * 车牌所在地
     */
    private String cardCity;
    /**
     * 所在区名
     */
    private String districtName;
    /**
     * 卖家描述
     */
    private String sellerDescription;
    /**
     * 年检到期描述
     */
    private String auditDate;
    /**
     * 交强险到期描述
     */
    private String strongInsuranceDate;
    /**
     * 商业险到期描述
     */
    private String insuranceDate;
    /**
     * 折让价
     */
    private String dealPrice;
    /**
     *
     */
    private transient String serviceCharge;

    /**
     * 新车价格
     */
    private String newPrice;

    /**
     * 使用年限
     */
    private String useDate;

    /**
     * 关注人数
     */
    private String followNum;

    /**
     * 排放标准
     */
    private String emissionStandard;

    /**
     * 排放标准提示
     */
    private String emissionStandardDesc;
    /**
     * 排放标准提示h5 url
     */
    private String emissionStandardsUrl;
    /**
     * 高配属性项目
     */
    private transient String highlightConfigItem;
    /**
     * 合格证图标
     */
    private String hegeIcon;
    /**
     * 检测描述
     */
    private String evaluatorDesc;
    /**
     * 检测详细项目
     */
    private transient String evaluateItem;
    /**
     *
     */
    private transient String service;
    /**
     *
     */
    private transient String serviceDesc;

    /**
     * 最高赔付额
     */
    private transient String compensationAmount;
    /**
     *
     */
    private transient String imageList;
    /**
     * 联系电话
     */
    private String phone;
    /**
     *
     */
    private transient String imageCategoryList;


    @Override
    protected Serializable pkVal() {
        return id;
    }
}
