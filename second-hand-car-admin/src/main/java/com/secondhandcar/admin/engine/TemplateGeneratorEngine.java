package com.secondhandcar.admin.engine;

import com.secondhandcar.admin.config.*;
import com.secondhandcar.core.utils.ToolUtil;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 模板生成引擎
 * Created by xiet on 2017/10/12.
 */
public abstract class TemplateGeneratorEngine {

    protected ContextConfig contextConfig;                //全局配置
    protected ControllerConfig controllerConfig;          //控制器的配置
    protected PageConfig pageConfig;                      //页面的控制器
    protected DaoConfig daoConfig;                        //Dao配置
    protected ServiceConfig serviceConfig;                //Service配置

    public void initConfig() {
        if (this.contextConfig == null) {
            this.contextConfig = new ContextConfig();
        }
        if (this.controllerConfig == null) {
            this.controllerConfig = new ControllerConfig();
        }
        if (this.pageConfig == null) {
            this.pageConfig = new PageConfig();
        }
        if (this.daoConfig == null) {
            this.daoConfig = new DaoConfig();
        }
        if (this.serviceConfig == null) {
            this.serviceConfig = new ServiceConfig();
        }

        this.controllerConfig.setContextConfig(this.contextConfig);
        this.controllerConfig.init();

        this.serviceConfig.setContextConfig(this.contextConfig);
        this.serviceConfig.init();

        this.daoConfig.setContextConfig(this.contextConfig);
        this.daoConfig.init();

        this.pageConfig.setContextConfig(this.contextConfig);
        this.pageConfig.init();
    }

    public PageConfig getPageConfig() {
        return pageConfig;
    }

    public void setPageConfig(PageConfig pageConfig) {
        this.pageConfig = pageConfig;
    }

    public ContextConfig getContextConfig() {
        return contextConfig;
    }

    public void setContextConfig(ContextConfig contextConfig) {
        this.contextConfig = contextConfig;
    }

    public ControllerConfig getControllerConfig() {
        return controllerConfig;
    }

    public void setControllerConfig(ControllerConfig controllerConfig) {
        this.controllerConfig = controllerConfig;
    }

    public DaoConfig getDaoConfig() {
        return daoConfig;
    }

    public void setDaoConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }

    public ServiceConfig getServiceConfig() {
        return serviceConfig;
    }

    public void setServiceConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    protected GroupTemplate groupTemplate;

    public TemplateGeneratorEngine() {
        initBeetlEngine();
    }

    public void initBeetlEngine() {
        Properties properties = new Properties();
        properties.put("RESOURCE.root", "");
        properties.put("DELIMITER_STATEMENT_START", "<%");
        properties.put("DELIMITER_STATEMENT_END", "%>");
        properties.put("HTML_TAG_FLAG", "##");
        Configuration cfg = null;
        try {
            cfg = new Configuration(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        groupTemplate = new GroupTemplate(resourceLoader, cfg);
        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
    }

    public void configTemplate(Template template) {
        template.binding("controller", getControllerConfig());
        template.binding("context", getContextConfig());
        template.binding("dao", getDaoConfig());
        template.binding("service", getServiceConfig());
    }

    public void generateFile(String template, String filePath) {
        Template pageTemplate = groupTemplate.getTemplate(template);
        configTemplate(pageTemplate);
        //if(PlatformUtil.isWindows()){
        //filePath = filePath.replaceAll("/+|\\\\+","\\\\");
        //}else{
        filePath = filePath.replaceAll("/+|\\\\+", "/");
//        }
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            pageTemplate.renderTo(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        //配置之间的相互依赖
        initConfig();

        //生成模板
        if (contextConfig.getControllerSwitch()) {
            generateController();
        }
        if (contextConfig.getIndexPageSwitch()) {
            generatePageHtml();
        }
        if (contextConfig.getAddPageSwitch()) {
            generatePageAddHtml();
        }
        if (contextConfig.getEditPageSwitch()) {
            generatePageEditHtml();
        }
        if (contextConfig.getJsSwitch()) {
            generatePageJs();
        }
        if (contextConfig.getInfoJsSwitch()) {
            generatePageInfoJs();
        }
        if (contextConfig.getDaoSwitch()) {
            generateDao();
        }
        if (contextConfig.getServiceSwitch()) {
            generateService();
        }

    }

    protected abstract void generatePageEditHtml();

    protected abstract void generatePageAddHtml();

    protected abstract void generatePageInfoJs();

    protected abstract void generatePageJs();

    protected abstract void generatePageHtml();

    protected abstract void generateController();

    protected abstract void generateDao();

    protected abstract void generateService();

}
