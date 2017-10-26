package com.secondhandcar.admin.service;

/**
 * Created by xiet on 2017/10/26.
 */
public interface PermissionCheckService {
    /**
     * 检查指定角色
     * @param permissions
     * @return boolean
     */
    boolean check(Object[] permissions);

    /**
     * 检查全体角色
     * @return boolean
     */
    boolean checkAll();
}
