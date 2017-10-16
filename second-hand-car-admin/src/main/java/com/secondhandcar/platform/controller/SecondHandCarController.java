package com.secondhandcar.platform.controller;

import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.utils.ToolUtil;
import com.secondhandcar.platform.model.SecondHandCar;
import com.secondhandcar.platform.model.SecondHandCarHotParam;
import com.secondhandcar.platform.service.SecondHandCarHotParamService;
import com.secondhandcar.platform.service.SecondHandCarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private SecondHandCarHotParamService secondHandCarHotParamService;

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
    @RequestMapping("/secondHandCar_edit/{id}")
    public String secondHandCarEdit(@PathVariable Integer id, Model model) {
        SecondHandCar secondHandCar = secondHandCarService.selectById(id);
        model.addAttribute("secondHandCar", secondHandCar);
        List<SecondHandCarHotParam> secondHandCarHotParamList = secondHandCarHotParamService.selectListByCarId(secondHandCar.getCarId());
        model.addAttribute("secondHandCarHotParamList", secondHandCarHotParamList);
        return PREFIX + "secondHandCar_edit.html";
    }

    /**
     * 获取二手车列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {

        return secondHandCarService.selectSecondHandCars();
    }

    public static void main(String[] args) {
        System.out.println(ToolUtil.getSecondHandCarId());
        System.out.println(ToolUtil.getSecondHandCarId());
        System.out.println(ToolUtil.getSecondHandCarId());
        System.out.println(ToolUtil.getSecondHandCarId());
    }
    /**
     * 新增二手车
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(SecondHandCar secondHandCar) {
        secondHandCar.setCarId(ToolUtil.getSecondHandCarId());
        secondHandCarService.add(secondHandCar);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除二手车
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(Integer id) {
        secondHandCarService.delete(id);
        return SUCCESS_TIP;
    }


    /**
     * 修改二手车
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(SecondHandCar secondHandCar) {
        secondHandCarService.update(secondHandCar);
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
