package com.secondhandcar.admin.service.impl;

import com.secondhandcar.admin.common.enums.UserStatusEnum;
import com.secondhandcar.admin.common.factory.ConstantFactory;
import com.secondhandcar.admin.dao.MenuDao;
import com.secondhandcar.admin.dao.UserDao;
import com.secondhandcar.admin.model.User;
import com.secondhandcar.admin.service.ShiroService;
import com.secondhandcar.admin.utils.ShiroUser;
import com.secondhandcar.admin.utils.SpringContextHolder;
import com.secondhandcar.core.utils.ConvertUtils;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiet on 2017/10/24.
 */
@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroServiceImpl implements ShiroService {

    @Resource
    private UserDao userDao;

    @Resource
    private MenuDao menuDao;

    public static ShiroService me() {
        return SpringContextHolder.getBean(ShiroService.class);
    }

    @Override
    public User user(String account) {
        User user = userDao.getByAccount(account);
        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
        if (user.getStatus() != UserStatusEnum.OK.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getId());            // 账号id
        shiroUser.setAccount(user.getAccount());// 账号
        shiroUser.setDeptId(user.getDeptid());    // 部门id
        shiroUser.setDeptName(ConstantFactory.me().getDeptName(user.getDeptid()));// 部门名称
        shiroUser.setName(user.getName());        // 用户名称

        Integer[] roleArray = ConvertUtils.toIntArray(user.getRoleid());// 角色集合
        List<Integer> roleList = new ArrayList<Integer>();
        List<String> roleNameList = new ArrayList<String>();
        for (int roleId : roleArray) {
            roleList.add(roleId);
            roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);

        return shiroUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        List<String> resUrls = menuDao.getResUrlsByRoleId(roleId);
        return resUrls;
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return ConstantFactory.me().getSingleRoleTip(roleId);
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }
}
