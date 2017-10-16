package com.secondhandcar.api.service;

import com.secondhandcar.api.model.SecondHandCar;

import java.util.List;

/**
 * 二手车服务
 *
 */
public interface SecondHandCarService {
    /**
     * 查询二手车列表
     * @return
     */
    public List<SecondHandCar> findSecondHandCarList();
}
