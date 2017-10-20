package com.secondhandcar.api.service;

import com.secondhandcar.api.model.SecondHandCar;
import com.secondhandcar.api.model.SecondHandCarDetail;

/**
 * Created by xiet on 2017/10/17.
 */
public interface SecondHandCarDetailService {

    /**
     * 获取二手车详细信息
     * @param secondHandCar
     * @return
     */
    SecondHandCarDetail findSecondHandCarDetail(SecondHandCar secondHandCar);
}
