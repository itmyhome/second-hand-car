package com.secondhandcar.platform.service;

import com.secondhandcar.platform.model.SecondHandCar;

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

}
