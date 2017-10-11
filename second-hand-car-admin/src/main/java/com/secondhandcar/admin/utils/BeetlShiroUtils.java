package com.secondhandcar.admin.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * beetl模板集成shiro功能
 * Created by xiet on 2017/10/10.
 */
public class BeetlShiroUtils {

    /**
     * 获取当前 Subject
     *
     * @return Subject
     */
    protected static Subject getSubject() {
        return SecurityUtils.getSubject();
    }
    /**
     * 验证当前用户是否拥有指定权限,使用时与lacksPermission 搭配使用
     *
     * @param permission 权限名
     * @return 拥有权限：true，否则false
     */
    public boolean hasPermission(String permission) {
        return getSubject() != null && permission != null
                && permission.length() > 0
                && getSubject().isPermitted(permission);
    }
}
