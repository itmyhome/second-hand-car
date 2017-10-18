package com.secondhandcar.api.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.secondhandcar.api.dao.SecondHandCarDao;
import com.secondhandcar.api.model.SecondHandCar;
import com.secondhandcar.api.service.SecondHandCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 二手车服务实现类
 */
@Service
public class SecondHandCarServiceImpl implements SecondHandCarService{

    @Resource
    private SecondHandCarDao secondHandCarDao;
    /**
     * 获取二手车列表
     * @return
     */
    public List<SecondHandCar> getSecondHandCars(){
        List<SecondHandCar> secondHandCarMap = secondHandCarDao.getSecondHandCars();
        return secondHandCarMap;
    }
}
