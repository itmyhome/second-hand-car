package com.secondhandcar.core.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.InputStream;
import java.util.UUID;

/**
 * Created by xiet on 2017/10/13.
 */
@org.springframework.context.annotation.Configuration
@Slf4j
@ConfigurationProperties(prefix = FileUploadUtils.PREFIX)
public class FileUploadUtils {
    public static final String PREFIX = "fileUploadUtils";

    private String accessKey;
    private String secretKey;
    private String storageSpace;
    private String fileUrlPrefix;

    public String getFileUrlPrefix() {
        return fileUrlPrefix;
    }

    public void setFileUrlPrefix(String fileUrlPrefix) {
        this.fileUrlPrefix = fileUrlPrefix;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(String storageSpace) {
        this.storageSpace = storageSpace;
    }

    public String upload(InputStream input) {
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);
        UploadManager uploadManager = new UploadManager(c);
        Auth auth = Auth.create(accessKey, secretKey);
        String fileName = UUID.randomUUID().toString().replaceAll("-", "");
        log.info(fileName);
        String token = auth.uploadToken(storageSpace);
        try {
            Response r = uploadManager.put(input, fileName, token, null, null);
            log.info(r.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
