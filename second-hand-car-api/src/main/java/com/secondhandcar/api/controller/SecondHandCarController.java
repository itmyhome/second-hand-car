package com.secondhandcar.api.controller;

import com.secondhandcar.api.model.SecondHandCar;
import com.secondhandcar.api.service.SecondHandCarService;
import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.utils.ReturnResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
     * 查询二手车列表
     * @return
     */
    public Object findSecondHandCarList(){
        List<SecondHandCar> list = secondHandCarService.findSecondHandCarList();
        return new ReturnResult();
    }


}
