package com.secondhandcar.platform.service.impl;

import com.secondhandcar.admin.utils.DictUtils;
import com.secondhandcar.platform.dao.SecondHandCarDao;
import com.secondhandcar.platform.model.SecondHandCar;
import com.secondhandcar.platform.model.SecondHandCarHotParam;
import com.secondhandcar.platform.service.SecondHandCarHotParamService;
import com.secondhandcar.platform.service.SecondHandCarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

        this.insertSecondHandCarHotParam(secondHandCar);


    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(SecondHandCar secondHandCar) {
        secondHandCarDao.updateById(secondHandCar);

        secondHandCarHotParamService.deleteByCarId(secondHandCar.getCarId());

        this.insertSecondHandCarHotParam(secondHandCar);


    }

    private void insertSecondHandCarHotParam(SecondHandCar secondHandCar){
        List<Map<String, String>> items = DictUtils.parseKeyValue(secondHandCar.getSecondHandCarHotParamStr());


        for (Map<String, String> item : items) {
            String num = item.get(DictUtils.MUTI_STR_KEY);
            String name = item.get(DictUtils.MUTI_STR_VALUE);
            SecondHandCarHotParam secondHandCarHotParam = new SecondHandCarHotParam();
            secondHandCarHotParam.setCarId(secondHandCar.getCarId());
            secondHandCarHotParam.setText(num);
            secondHandCarHotParam.setColor(name);
            secondHandCarHotParamService.add(secondHandCarHotParam);
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer id) {
        secondHandCarDao.deleteById(id);
    }

    @Override
    public SecondHandCar selectById(Integer id) {
        return secondHandCarDao.selectById(id);
    }
}
