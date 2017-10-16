package com.secondhandcar.platform.service;

import com.secondhandcar.platform.model.SecondHandCar;

import java.util.List;
import java.util.Map;

/**
 * 二手车Service
 *
 * @author xietao
 * @Date 2017-10-13T22:46:51.458
 */
public interface SecondHandCarService {

    void add(SecondHandCar secondHandCar);

    void update(SecondHandCar secondHandCar);

    void delete(Integer id);

    SecondHandCar selectById(Integer id);

    List<Map<String, Object>> selectSecondHandCars();

}
