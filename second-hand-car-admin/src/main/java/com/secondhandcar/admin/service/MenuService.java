package com.secondhandcar.admin.service;

/**
 * Created by xiet on 2017/10/11.
 */
public interface MenuService {

    /**
     * 删除菜单
     *
     */
    void delMenu(Integer menuId);

    /**
     * 删除菜单包含所有子菜单
     *
     */
    void delMenuContainSubMenus(Integer menuId);
}
