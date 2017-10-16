package com.secondhandcar.platform.service;

import com.secondhandcar.platform.base.BaseJunit;
import com.secondhandcar.platform.model.SecondHandCarHotParam;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xiet on 2017/10/15.
 */
public class SecondHandCarHotParamTest extends BaseJunit {

    @Resource
    private SecondHandCarHotParamService secondHandCarHotParamService;

    @Test
    public void add(){
        for (int i = 0; i < 5; i++) {
            SecondHandCarHotParam secondHandCarHotParam = new SecondHandCarHotParam();
            secondHandCarHotParam.setCardId("12345");
            secondHandCarHotParam.setText("新车");
            secondHandCarHotParam.setColor("#12345");
            secondHandCarHotParamService.add(secondHandCarHotParam);
        }


    }

    @Test
    public void update(){
        SecondHandCarHotParam secondHandCarHotParam = new SecondHandCarHotParam();
        secondHandCarHotParam.setId(1);
        secondHandCarHotParam.setCardId("66666");
        secondHandCarHotParam.setText("新车333");
        secondHandCarHotParam.setColor("#12345");

        secondHandCarHotParamService.update(secondHandCarHotParam);
    }

    @Test
    public void delete(){
        secondHandCarHotParamService.delete(1);
    }
}
