package com.secondhandcar.api.controller;

import com.secondhandcar.api.model.SecondHandCar;
import com.secondhandcar.api.service.SecondHandCarService;
import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.utils.ResultBuilderUtil;
import com.secondhandcar.core.utils.ReturnResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 二手车控制类
 * Created by xiet on 2017/10/16.
 */
@Controller
@RequestMapping(value="/secondHandCar")
public class SecondHandCarController extends BaseController{

    @Resource
    private SecondHandCarService secondHandCarService;

    /**
     * 获取二手车列表
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object getSecondHandCars(String condition){
        List<SecondHandCar> carList = secondHandCarService.getSecondHandCars();
        return ResultBuilderUtil.success(carList);
    }

    /**
     * 获取二手车详情信息
     * @param carId
     * @return
     */
    @RequestMapping(value="/detail")
    @ResponseBody
    public Object getSecondHandCarDetail(String carId){
        return null;
    }

    /**
     * 获取二手车配置信息
     * @param carId
     * @return
     */
    @RequestMapping(value="/config")
    @ResponseBody
    public Object getSecondHandCarConfig(String carId){
        return null;
    }

}
