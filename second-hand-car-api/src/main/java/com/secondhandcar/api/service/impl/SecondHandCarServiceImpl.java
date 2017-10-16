package com.secondhandcar.api.service.impl;

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
     * 查询二手车列表
     * @return
     */
    public List<SecondHandCar> findSecondHandCarList(){
        List<SecondHandCar> list = secondHandCarDao.findSecondHandCarList();
        if(list != null && list.size() != 0){
            return list;
        }else{
            return new ArrayList<>();
        }
    }
}
