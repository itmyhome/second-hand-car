package com.secondhandcar.platform.service;

import com.secondhandcar.platform.base.BaseJunit;
import com.secondhandcar.platform.model.SecondHandCar;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by xiet on 2017/10/14.
 */
public class SecondHandCarTest extends BaseJunit {

    @Resource
    private SecondHandCarService secondHandCarService;


    @Test
    public void add() {

        SecondHandCar secondHandCar = new SecondHandCar();
        secondHandCar.setCarId("66666");
        secondHandCar.setTitle("大众宝来");
        secondHandCar.setLicenseDate(new Date());
        secondHandCar.setRoadHaul("5.4");
        secondHandCar.setPrice("11.8");
        secondHandCar.setFirstPay("2.8");

//        SecondHandCarHotParam secondHandCarHotParam = new SecondHandCarHotParam();
//        secondHandCarHotParam.setCardId("12345");
//        secondHandCarHotParam.setText("新车");
//        secondHandCarHotParam.setColor("#12345");
//        SecondHandCarHotParam secondHandCarHotParam2 = new SecondHandCarHotParam();
//        secondHandCarHotParam2.setCardId("12345");
//        secondHandCarHotParam2.setText("急售");
//        secondHandCarHotParam2.setColor("#66666");

        String secondHandCarHotParamStr = "11:11;22:22;888:333;222:344";
//        secondHandCarHotParamList.add(secondHandCarHotParam);
//        secondHandCarHotParamList.add(secondHandCarHotParam2);

        secondHandCar.setSecondHandCarHotParamStr(secondHandCarHotParamStr);

        secondHandCarService.add(secondHandCar);

    }

    @Test
    public void update() {
        SecondHandCar secondHandCar = new SecondHandCar();
        secondHandCar.setId(8);
        secondHandCar.setTitle("奥迪A8");
//        secondHandCar.setLicenseDate("");
//        secondHandCar.setRoadHaul("5.4");
//        secondHandCar.setPrice("11.8");
//        secondHandCar.setFirstPay("2.8");
        secondHandCar.setCarId("66666");
        String secondHandCarHotParamStr = "11:77;88:22;888:333;222:344";
        secondHandCar.setSecondHandCarHotParamStr(secondHandCarHotParamStr);
        secondHandCarService.update(secondHandCar);
    }

    @Test
    public void delete() {

    }
}
