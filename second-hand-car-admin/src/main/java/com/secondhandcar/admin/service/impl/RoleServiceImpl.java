package com.secondhandcar.admin.service.impl;

import com.secondhandcar.admin.dao.RelationDao;
import com.secondhandcar.admin.dao.RoleDao;
import com.secondhandcar.admin.model.Relation;
import com.secondhandcar.admin.service.RoleService;
import com.secondhandcar.core.utils.ConvertUtils;
import com.sun.tools.javac.util.Convert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiet on 2017/10/11.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Resource
    private RelationDao relationDao;
    @Override
    public void setAuthority(Integer roleId, String ids) {
        // 删除该角色所有的权限
        this.roleDao.deleteRolesById(roleId);

        // 添加新的权限
        for (Integer id : ConvertUtils.toIntArray(ids)) {
            Relation relation = new Relation();
            relation.setRoleid(roleId);
            relation.setMenuid(id);
            relationDao.insert(relation);
        }
    }

    @Override
    public void delRoleById(Integer roleId) {
        //删除角色
        this.roleDao.deleteById(roleId);

        // 删除该角色所有的权限
        this.roleDao.deleteRolesById(roleId);
    }
}
