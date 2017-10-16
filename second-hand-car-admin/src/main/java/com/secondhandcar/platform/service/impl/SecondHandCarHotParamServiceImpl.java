package com.secondhandcar.platform.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Maps;
import com.secondhandcar.platform.dao.SecondHandCarHotParamDao;
import com.secondhandcar.platform.model.SecondHandCarHotParam;
import com.secondhandcar.platform.service.SecondHandCarHotParamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public void deleteByCarId(String secondHandCarId) {
        Map<String, Object> columnMap = Maps.newHashMap();
        columnMap.put("car_id", secondHandCarId);
        secondHandCarHotParamDao.deleteByMap(columnMap);
    }

    @Override
    public List<SecondHandCarHotParam> selectListByCarId(String secondHandCarId) {

        return secondHandCarHotParamDao.selectList(new EntityWrapper<SecondHandCarHotParam>().eq("car_id", secondHandCarId));
    }
}
