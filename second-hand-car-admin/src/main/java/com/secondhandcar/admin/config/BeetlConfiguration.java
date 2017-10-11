package com.secondhandcar.admin.config;

import com.secondhandcar.admin.utils.BeetlShiroUtils;
import com.secondhandcar.core.utils.ToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

@Slf4j
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void initOther() {
        log.info("初始化其他");
        groupTemplate.registerFunctionPackage("shiro", new BeetlShiroUtils());
        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
//        groupTemplate.registerFunctionPackage("kaptcha", new KaptchaUtil());

    }

}