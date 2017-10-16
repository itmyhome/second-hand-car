package com.secondhandcar.platform.controller;

import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.platform.model.SecondHandCar;
import com.secondhandcar.platform.service.SecondHandCarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * 二手车控制器
 *
 * @author xietao
 * @Date 2017-10-13T22:46:51.433
 */
@Controller
@RequestMapping("/secondHandCar")
public class SecondHandCarController extends BaseController {

    private String PREFIX = "/platform/";

    @Resource
    private SecondHandCarService secondHandCarService;

    /**
     * 跳转到二手车首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "secondHandCar.html";
    }

    /**
     * 跳转到添加二手车
     */
    @RequestMapping("/secondHandCar_add")
    public String secondHandCarAdd() {
        return PREFIX + "secondHandCar_add.html";
    }

    /**
     * 跳转到修改二手车
     */
    @RequestMapping("/secondHandCar_update/{secondHandCarId}")
    public String secondHandCarUpdate(@PathVariable Integer secondHandCarId, Model model) {
        return PREFIX + "secondHandCar_edit.html";
    }

    /**
     * 获取二手车列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return null;
    }

    /**
     * 新增二手车
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SecondHandCar secondHandCar) {
        secondHandCarService.add(secondHandCar);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除二手车
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete() {
        return SUCCESS_TIP;
    }


    /**
     * 修改二手车
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update() {
        return super.SUCCESS_TIP;
    }

    /**
     * 二手车详情
     */
    @RequestMapping(value = "/detail")
    @ResponseBody
    public Object detail() {
        return null;
    }
}
