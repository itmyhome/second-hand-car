package com.secondhandcar.api.controller;

import com.secondhandcar.api.dto.SecondHandCarDetailResponseDTO;
import com.secondhandcar.api.dto.SecondHandCarResponseDTO;
import com.secondhandcar.api.service.SecondHandCarDetailService;
import com.secondhandcar.api.service.SecondHandCarService;
import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.utils.ResultBuilderUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 二手车控制类
 * Created by xiet on 2017/10/16.
 */
@Controller
@RequestMapping(value = "/secondHandCar")
public class SecondHandCarController extends BaseController{

    @Resource
    private SecondHandCarService secondHandCarService;

    @Resource
    private SecondHandCarDetailService secondHandCarDetailService;

    /**
     * 获取二手车列表
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object findSecondHandCars(String condition){
        List<SecondHandCarResponseDTO> response = secondHandCarService.findSecondHandCars();
        return ResultBuilderUtil.success(response);
    }

    /**
     * 获取二手车详情信息
     * @param carId
     * @return
     */
    @RequestMapping(value="/detail/{carId}")
    @ResponseBody
    public Object findSecondHandCarDetail(@PathVariable String carId){
        SecondHandCarDetailResponseDTO response = secondHandCarDetailService.findSecondHandCarDetail(carId);
        return ResultBuilderUtil.success(response);
    }

    /**
     * 获取二手车配置信息
     * @param carId
     * @return
     */
    @RequestMapping(value="/config/{carId}")
    @ResponseBody
    public Object findSecondHandCarConfig(@PathVariable String carId){
        return ResultBuilderUtil.success();
    }

}
