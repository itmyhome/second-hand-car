package com.secondhandcar.platform.service.impl;

import com.secondhandcar.platform.dao.SecondHandCarDao;
import com.secondhandcar.platform.model.SecondHandCar;
import com.secondhandcar.platform.model.SecondHandCarHotParam;
import com.secondhandcar.platform.service.SecondHandCarHotParamService;
import com.secondhandcar.platform.service.SecondHandCarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 二手车Service
 *
 * @author xietao
 * @Date 2017-10-13T22:46:51.460
 */
@Service
public class SecondHandCarServiceImpl implements SecondHandCarService {

    @Resource
    private SecondHandCarDao secondHandCarDao;

    @Resource
    private SecondHandCarHotParamService secondHandCarHotParamService;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void add(SecondHandCar secondHandCar) {
        secondHandCarDao.insert(secondHandCar);
        for (SecondHandCarHotParam secondHandCarHotParam : secondHandCar.getSecondHandCarHotParamList()) {
            secondHandCarHotParamService.add(secondHandCarHotParam);
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(SecondHandCar secondHandCar) {
        secondHandCarDao.updateById(secondHandCar);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer secondHandCarId) {
        secondHandCarDao.deleteById(secondHandCarId);
    }
}
