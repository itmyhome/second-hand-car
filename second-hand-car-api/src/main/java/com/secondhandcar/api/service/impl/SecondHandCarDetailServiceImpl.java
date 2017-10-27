package com.secondhandcar.api.service.impl;

import com.secondhandcar.api.dao.SecondHandCarDetailDao;
import com.secondhandcar.api.dto.SecondHandCarDetailResponseDTO;
import com.secondhandcar.api.model.SecondHandCar;
import com.secondhandcar.api.service.SecondHandCarDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SecondHandCarDetailServiceImpl implements SecondHandCarDetailService{

    @Resource
    private SecondHandCarDetailDao secondHandCarDetailDao;
    /**
     * 获取二手车详细信息
     * @param carId
     * @return
     */
    @Override
    public SecondHandCarDetailResponseDTO findSecondHandCarDetail(String carId) {
        SecondHandCarDetailResponseDTO response = new SecondHandCarDetailResponseDTO();
        if(carId != null){
            response = secondHandCarDetailDao.findSecondHandCarDetail(carId);
        }
        return response;
    }
}
