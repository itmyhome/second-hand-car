package com.secondhandcar.platform.controller;

import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.platform.model.*;
import com.secondhandcar.platform.service.SecondHandCarDetailService;
import com.secondhandcar.platform.service.SecondHandCarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
        SecondHandCarDetail secondHandCarDetail = secondHandCarDetailService.selectByCarId(secondHandCar.getCarId());
        List<SecondHandCarEvaluateItem> secondHandCarEvaluateItemList = secondHandCarDetailService.selectEvaluateItemListByCarId(secondHandCar.getCarId());
        List<SecondHandCarHighlightConfigItem> secondHandCarHighlightConfigItemsList = secondHandCarDetailService.selectHighlightConfigItemListByCarId(secondHandCar.getCarId());
        model.addAttribute("secondHandCar", secondHandCar);
        model.addAttribute("secondHandCarDetail", secondHandCarDetail);
        model.addAttribute("secondHandCarEvaluateItemList", secondHandCarEvaluateItemList);
        model.addAttribute("secondHandCarHighlightConfigItemsList", secondHandCarHighlightConfigItemsList);

        return PREFIX + "secondHandCarDetail_edit.html";
    }

    /**
     * 修改二手车详情
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SecondHandCarDetail secondHandCarDetail) {


        secondHandCarDetailService.update(secondHandCarDetail);


//        secondHandCarService.update(secondHandCar);
        return super.SUCCESS_TIP;
    }

}
