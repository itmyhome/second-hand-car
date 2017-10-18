package com.secondhandcar.platform.service;

import com.secondhandcar.platform.model.SecondHandCarDetail;
import com.secondhandcar.platform.model.SecondHandCarEvaluateItems;
import com.secondhandcar.platform.model.SecondHandCarHighlightConfigItem;

/**
 * Created by xiet on 2017/10/17.
 */
public interface SecondHandCarDetailService {

    void add(SecondHandCarDetail secondHandCarDetail);

    void update(SecondHandCarDetail secondHandCarDetail);

    /**
     * 新增或修改详细检测项目
     * @param secondHandCarEvaluateItems
     */
    void addOrEditSecondHandCarEvaluateItems(SecondHandCarEvaluateItems secondHandCarEvaluateItems);

    /**
     * 新增或修改高亮配置项目
     * @param secondHandCarHighlightConfigItem
     */
    void addOrEditSecondHandCarHighlightConfigItem(SecondHandCarHighlightConfigItem secondHandCarHighlightConfigItem);
}
