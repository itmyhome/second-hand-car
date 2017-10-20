package com.secondhandcar.api.service.impl;

import com.secondhandcar.api.dao.SecondHandCarDetailDao;
import com.secondhandcar.api.model.SecondHandCar;
import com.secondhandcar.api.model.SecondHandCarDetail;
import com.secondhandcar.api.service.SecondHandCarDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SecondHandCarDetailServiceImpl implements SecondHandCarDetailService{

    @Resource
    private SecondHandCarDetailDao secondHandCarDetailDao;
    /**
     * 获取二手车详细信息
     * @param secondHandCar
     * @return
     */
    @Override
    public SecondHandCarDetail findSecondHandCarDetail(SecondHandCar secondHandCar) {
        SecondHandCarDetail secondHandCarDetail = new SecondHandCarDetail();
        if(secondHandCar != null){
            String carId = secondHandCar.getCarId();
            secondHandCarDetail = secondHandCarDetailDao.findSecondHandCarDetail(carId);
        }

        return secondHandCarDetail;
    }
}
