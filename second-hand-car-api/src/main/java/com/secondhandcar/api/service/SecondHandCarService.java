package com.secondhandcar.api.service;

import com.secondhandcar.api.dto.SecondHandCarResponseDTO;

import java.util.List;

/**
 * 二手车服务
 *
 */
public interface SecondHandCarService {
    /**
     * 获取二手车列表
     * @return
     */
    List<SecondHandCarResponseDTO> findSecondHandCars();

}
