package com.secondhandcar.admin.config;

import com.secondhandcar.core.utils.StringUtils;
import com.secondhandcar.core.utils.ToolUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by xiet on 2017/10/13.
 */
@Component
@ConfigurationProperties(prefix = FileUploadConfig.PREFIX)
public class FileUploadConfig {

    public static final String PREFIX = "fileUploadConfig";

    private String fileUploadPath;

    private Boolean haveCreatePath = false;

    public String getFileUploadPath() {
        //如果没有写文件上传路径,保存到临时目录
        if (StringUtils.isEmpty(fileUploadPath)) {
            return ToolUtil.getTempPath();
        } else {
            //判断有没有结尾符,没有得加上
            if (!fileUploadPath.endsWith(File.separator)) {
                fileUploadPath = fileUploadPath + File.separator;
            }
            //判断目录存不存在,不存在得加上
            if (haveCreatePath == false) {
                File file = new File(fileUploadPath);
                file.mkdirs();
                haveCreatePath = true;
            }
            return fileUploadPath;
        }
    }
}
