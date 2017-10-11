package com.secondhandcar.admin.service;

/**
 * Created by xiet on 2017/10/11.
 */
public interface RoleService {

    /**
     * 设置某个角色的权限
     *
     * @param roleId 角色id
     * @param ids    权限的id
     */
    void setAuthority(Integer roleId, String ids);

    /**
     * 删除角色
     *
     * @author stylefeng
     */
    void delRoleById(Integer roleId);
}
