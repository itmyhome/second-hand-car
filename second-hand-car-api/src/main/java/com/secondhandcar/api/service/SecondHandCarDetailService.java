package com.secondhandcar.api.service;

import com.secondhandcar.api.dto.SecondHandCarDetailResponseDTO;
import com.secondhandcar.api.model.SecondHandCar;

/**
 * Created by xiet on 2017/10/17.
 */
public interface SecondHandCarDetailService {

    /**
     * 获取二手车详细信息
     * @param carId
     * @return
     */
    SecondHandCarDetailResponseDTO findSecondHandCarDetail(String carId);

}
