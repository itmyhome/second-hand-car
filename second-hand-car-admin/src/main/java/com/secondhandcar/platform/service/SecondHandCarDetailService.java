package com.secondhandcar.platform.service;

import com.secondhandcar.platform.model.SecondHandCarDetail;
import com.secondhandcar.platform.model.SecondHandCarEvaluateItem;
import com.secondhandcar.platform.model.SecondHandCarHighlightConfigItem;

/**
 * Created by xiet on 2017/10/17.
 */
public interface SecondHandCarDetailService {

    void add(SecondHandCarDetail secondHandCarDetail);

    /**
     * 更新二手车详情表，二手车详细配置表，二手车高配属性表
     * @param secondHandCarDetail
     */
    void update(SecondHandCarDetail secondHandCarDetail);

    SecondHandCarDetail selectById(Integer id);

    /**
     * 新增或修改详细检测项目
     * @param secondHandCarEvaluateItems
     */
    void addOrEditSecondHandCarEvaluateItems(SecondHandCarEvaluateItem secondHandCarEvaluateItems);

    /**
     * 根据carId删除详细检测项目
     * @param carId
     */
    void deleteEvaluateItemsByCarId(String carId);

    /**
     * 新增或修改高亮配置项目
     * @param secondHandCarHighlightConfigItem
     */
    void addOrEditSecondHandCarHighlightConfigItem(SecondHandCarHighlightConfigItem secondHandCarHighlightConfigItem);

    /**
     * 根据carId删除高配属性
     * @param carId
     */
    void deleteHighlightConfigItem(String carId);
}
