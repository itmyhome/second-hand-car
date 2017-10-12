package com.secondhandcar.admin.engine;

import com.secondhandcar.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleTemplateEngine extends TemplateGeneratorEngine {

    @Override
    protected void generatePageEditHtml() {
        String path = StringUtils.format(super.getContextConfig().getProjectPath() + getPageConfig().getPageEditPathTemplate(),
                super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
        generateFile("codeTemplate/page_edit.html.btl", path);
        log.info("生成编辑页面成功!");
    }

    @Override
    protected void generatePageAddHtml() {
        String path = StringUtils.format(super.getContextConfig().getProjectPath() + getPageConfig().getPageAddPathTemplate(),
                super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
        generateFile("codeTemplate/page_add.html.btl", path);
        log.info("生成添加页面成功!");
    }

    @Override
    protected void generatePageInfoJs() {
        String path = StringUtils.format(super.getContextConfig().getProjectPath() + getPageConfig().getPageInfoJsPathTemplate(),
                super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
        generateFile("codeTemplate/page_info.js.btl", path);
        log.info("生成页面详情js成功!");
    }

    @Override
    protected void generatePageJs() {
        String path = StringUtils.format(super.getContextConfig().getProjectPath() + getPageConfig().getPageJsPathTemplate(),
                super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
        generateFile("codeTemplate/page.js.btl", path);
        log.info("生成页面js成功!");
    }

    @Override
    protected void generatePageHtml() {
        String path = StringUtils.format(super.getContextConfig().getProjectPath() + getPageConfig().getPagePathTemplate(),
                super.getContextConfig().getBizEnName(), super.getContextConfig().getBizEnName());
        generateFile("codeTemplate/page.html.btl", path);
        log.info("生成页面成功!");
    }

    @Override
    protected void generateController() {
        String controllerPath = StringUtils.format(super.getContextConfig().getProjectPath() + super.getControllerConfig().getControllerPathTemplate(),
                StringUtils.firstCharToUpperCase(super.getContextConfig().getBizEnName()));
        generateFile("codeTemplate/Controller.java.btl", controllerPath);
        log.info("生成控制器成功!");
    }

    @Override
    protected void generateDao() {
        String daoPath = StringUtils.format(super.getContextConfig().getProjectPath() + super.getDaoConfig().getDaoPathTemplate(),
                StringUtils.firstCharToUpperCase(super.getContextConfig().getBizEnName()));
        generateFile("codeTemplate/Dao.java.btl", daoPath);
        log.info("生成Dao成功!");

        String mappingPath = StringUtils.format(super.getContextConfig().getProjectPath() + super.getDaoConfig().getXmlPathTemplate(),
                StringUtils.firstCharToUpperCase(super.getContextConfig().getBizEnName()));
        generateFile("codeTemplate/Mapping.xml.btl", mappingPath);
        log.info("生成Dao Mapping xml成功!");
    }

    @Override
    protected void generateService() {
        String servicePath = StringUtils.format(super.getContextConfig().getProjectPath() + super.getServiceConfig().getServicePathTemplate(),
                StringUtils.firstCharToUpperCase(super.getContextConfig().getBizEnName()));
        generateFile("codeTemplate/Service.java.btl", servicePath);
        log.info("生成Service成功!");

        String serviceImplPath = StringUtils.format(super.getContextConfig().getProjectPath() + super.getServiceConfig().getServiceImplPathTemplate(),
                StringUtils.firstCharToUpperCase(super.getContextConfig().getBizEnName()));
        generateFile("codeTemplate/ServiceImpl.java.btl", serviceImplPath);
        log.info("生成ServiceImpl成功!");
    }
}