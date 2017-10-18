package com.secondhandcar.platform.controller;

import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.platform.service.SecondHandCarDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by xiet on 2017/10/17.
 */
@Controller
@RequestMapping("/secondHandCarDetail")
public class SecondHandCarDetailController extends BaseController{
    private String PREFIX = "/platform/";

    @Resource
    private SecondHandCarDetailService secondHandCarDetailService;

    /**
     * 跳转到修改二手车详情
     */
    @RequestMapping("/secondHandCarDetail_edit/{id}")
    public String secondHandCarEdit(@PathVariable Integer id, Model model) {

        return PREFIX + "secondHandCar_edit.html";
    }

}
