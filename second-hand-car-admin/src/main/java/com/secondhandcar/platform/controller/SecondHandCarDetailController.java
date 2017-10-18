package com.secondhandcar.platform.controller;

import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.platform.model.SecondHandCar;
import com.secondhandcar.platform.model.SecondHandCarDetail;
import com.secondhandcar.platform.service.SecondHandCarDetailService;
import com.secondhandcar.platform.service.SecondHandCarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by xiet on 2017/10/17.
 */
@Controller
@RequestMapping("/secondHandCarDetail")
public class SecondHandCarDetailController extends BaseController{
    private String PREFIX = "/platform/";

    @Resource
    private SecondHandCarService secondHandCarService;

    @Resource
    private SecondHandCarDetailService secondHandCarDetailService;

    /**
     * 跳转到修改二手车详情
     */
    @RequestMapping("/secondHandCarDetail_edit/{id}")
    public String secondHandCarDetailEdit(@PathVariable Integer id, Model model) {
        SecondHandCar secondHandCar = secondHandCarService.selectById(id);
        model.addAttribute("secondHandCar", secondHandCar);

        return PREFIX + "secondHandCarDetail_edit.html";
    }

    /**
     * 修改二手车详情
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SecondHandCarDetail secondHandCarDetail) {
//        secondHandCarService.update(secondHandCar);
        return super.SUCCESS_TIP;
    }

}
