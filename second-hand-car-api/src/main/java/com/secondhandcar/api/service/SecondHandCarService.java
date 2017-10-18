package com.secondhandcar.api.service;

import com.secondhandcar.api.model.SecondHandCar;

import java.util.List;
import java.util.Map;

/**
 * 二手车服务
 *
 */
public interface SecondHandCarService {
    /**
     * 获取二手车列表
     * @return
     */
    List<SecondHandCar> getSecondHandCars();
}
