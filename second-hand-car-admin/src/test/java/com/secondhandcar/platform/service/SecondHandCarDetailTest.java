package com.secondhandcar.platform.service;

import com.secondhandcar.platform.base.BaseJunit;
import com.secondhandcar.platform.model.SecondHandCarDetail;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by xiet on 2017/10/20.
 */
public class SecondHandCarDetailTest extends BaseJunit {

    @Resource
    private SecondHandCarDetailService secondHandCarDetailService;

    @Test
    public void edit() {
        SecondHandCarDetail secondHandCarDetail = new SecondHandCarDetail();
        secondHandCarDetail.setId(2);
        secondHandCarDetail.setCarId("123");
        secondHandCarDetail.setAirDisplacement("1.6");
        secondHandCarDetail.setGearbox("手动");
        secondHandCarDetail.setSeller("江先生");
        secondHandCarDetail.setSellerJob("个体");
        secondHandCarDetail.setTransferNum("0");
        secondHandCarDetail.setCardCity("厦门");
        secondHandCarDetail.setDistrictName("湖里区");
        secondHandCarDetail.setSellerDescription("这辆车用了四年多一点不到五年，开的比较在意。平时经常开车，现在本车公里数不到14万公里。一直都是城市道路行驶，这辆车就是日常家用，上下班代步。一直有在做定期保养，车用了一段时间了，所以打算卖掉，欢迎大家前来进行试驾，非诚勿扰呦。");
        secondHandCarDetail.setAuditDate("2017-11-11");
        secondHandCarDetail.setStrongInsuranceDate("2017-11-11");
        secondHandCarDetail.setInsuranceDate("2017-11-11");
        secondHandCarDetail.setDealPrice("0");
        secondHandCarDetail.setNewPrice("15.8");
        secondHandCarDetail.setUseDate("4年5个月");
        secondHandCarDetail.setFollowNum("500");
        secondHandCarDetail.setEmissionStandard("郭汜");
        secondHandCarDetail.setEmissionStandardDesc("国家标准");
        secondHandCarDetail.setEmissionStandardsUrl("http://www.baidu.com");
        secondHandCarDetail.setHegeIcon("http://www.baidu.com");
        secondHandCarDetail.setEvaluatorDesc("检测合格");
        secondHandCarDetail.setPhone("40011111111");
        secondHandCarDetail.setEvaluateItem("1:2:3;3:4:5;3:4:5;3:4:5;3:4:5;3:4:5;3:4:5;3:4:5;3:4:5;3:4:5");
        secondHandCarDetail.setHighlightConfigItem("22:33:44;55:66:77;3:4:5;3:4:5;3:4:5;3:4:5");
        secondHandCarDetailService.update(secondHandCarDetail);
    }
}
