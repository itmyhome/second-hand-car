package com.secondhandcar.admin.controller;

import com.secondhandcar.admin.common.enums.BizExceptionEnum;
import com.secondhandcar.admin.common.exception.BussinessException;
import com.secondhandcar.admin.config.ContextConfig;
import com.secondhandcar.admin.engine.SimpleTemplateEngine;
import com.secondhandcar.admin.engine.TemplateGeneratorEngine;
import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.utils.ToolUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiet on 2017/10/12.
 */
@Controller
@RequestMapping("/code")
public class CodeController extends BaseController{

    private String PREFIX = "/system/code/";

    /**
     * 跳转到代码生成首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "code.html";
    }

    /**
     * 代码生成
     */
    @ApiOperation("生成代码")
    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @ResponseBody
    public Object add(@ApiParam(value = "模块名称",required = true) @RequestParam String moduleName,
                      @RequestParam String bizChName,
                      @RequestParam String bizEnName,
                      @RequestParam String path) {
        if (ToolUtil.isOneEmpty(bizChName, bizEnName)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        ContextConfig contextConfig = new ContextConfig();
        contextConfig.setBizChName(bizChName);
        contextConfig.setBizEnName(bizEnName);
        contextConfig.setModuleName(moduleName);
        if (ToolUtil.isNotEmpty(path)) {
            contextConfig.setProjectPath(path);
        }

        TemplateGeneratorEngine simpleTemplateEngine = new SimpleTemplateEngine();
        simpleTemplateEngine.setContextConfig(contextConfig);
        simpleTemplateEngine.start();

        return super.SUCCESS_TIP;
    }
}
