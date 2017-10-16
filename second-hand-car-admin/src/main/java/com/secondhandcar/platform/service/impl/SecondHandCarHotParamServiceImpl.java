package com.secondhandcar.platform.service.impl;

import com.secondhandcar.platform.dao.SecondHandCarHotParamDao;
import com.secondhandcar.platform.model.SecondHandCarHotParam;
import com.secondhandcar.platform.service.SecondHandCarHotParamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by xiet on 2017/10/14.
 */
@Service
public class SecondHandCarHotParamServiceImpl implements SecondHandCarHotParamService {

    @Resource
    private SecondHandCarHotParamDao secondHandCarHotParamDao;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void add(SecondHandCarHotParam secondHandCarHotParam) {
        secondHandCarHotParamDao.insert(secondHandCarHotParam);

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(SecondHandCarHotParam secondHandCarHotParam) {
        secondHandCarHotParamDao.updateById(secondHandCarHotParam);
    }

    @Override
    public void delete(Integer secondHandCarHotParamId) {
        secondHandCarHotParamDao.deleteById(secondHandCarHotParamId);
    }
}
