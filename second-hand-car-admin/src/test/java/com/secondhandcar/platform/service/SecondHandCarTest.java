package com.secondhandcar.platform.service;

import com.secondhandcar.platform.base.BaseJunit;
import com.secondhandcar.platform.model.SecondHandCar;
import com.secondhandcar.platform.model.SecondHandCarHotParam;
import org.assertj.core.util.Lists;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiet on 2017/10/14.
 */
public class SecondHandCarTest extends BaseJunit {

    @Resource
    private SecondHandCarService secondHandCarService;


    @Test
    public void add() {

        SecondHandCar secondHandCar = new SecondHandCar();
        secondHandCar.setCarId("12345");
        secondHandCar.setTitle("大众宝来");
        secondHandCar.setLicenseDate("");
        secondHandCar.setRoadHaul("5.4");
        secondHandCar.setPrice("11.8");
        secondHandCar.setFirstPay("2.8");

        SecondHandCarHotParam secondHandCarHotParam = new SecondHandCarHotParam();
        secondHandCarHotParam.setCardId("12345");
        secondHandCarHotParam.setText("新车");
        secondHandCarHotParam.setColor("#12345");
        SecondHandCarHotParam secondHandCarHotParam2 = new SecondHandCarHotParam();
        secondHandCarHotParam2.setCardId("12345");
        secondHandCarHotParam2.setText("急售");
        secondHandCarHotParam2.setColor("#66666");

        List<SecondHandCarHotParam> secondHandCarHotParamList = Lists.newArrayList();
        secondHandCarHotParamList.add(secondHandCarHotParam);
        secondHandCarHotParamList.add(secondHandCarHotParam2);

        secondHandCar.setSecondHandCarHotParamList(secondHandCarHotParamList);

        secondHandCarService.add(secondHandCar);

    }

    @Test
    public void update() {
        SecondHandCar secondHandCar = new SecondHandCar();
        secondHandCar.setId(1);
        secondHandCar.setCarId("1234567");
        secondHandCar.setTitle("大众宝来22");
//        secondHandCar.setLicenseDate("");
//        secondHandCar.setRoadHaul("5.4");
//        secondHandCar.setPrice("11.8");
//        secondHandCar.setFirstPay("2.8");
        secondHandCarService.update(secondHandCar);
    }

    @Test
    public void delete() {

    }
}
