package com.secondhandcar.api.service.impl;

import com.secondhandcar.api.dao.SecondHandCarDao;
import com.secondhandcar.api.dto.SecondHandCarResponseDTO;
import com.secondhandcar.api.service.SecondHandCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Override
    public List<SecondHandCarResponseDTO> findSecondHandCars(){
        List<SecondHandCarResponseDTO> response = secondHandCarDao.findSecondHandCars();
        return response;
    }

}
