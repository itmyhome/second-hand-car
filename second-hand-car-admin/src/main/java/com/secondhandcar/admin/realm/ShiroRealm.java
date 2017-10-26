package com.secondhandcar.admin.realm;

import com.secondhandcar.admin.model.User;
import com.secondhandcar.admin.service.ShiroService;
import com.secondhandcar.admin.utils.ShiroUser;
import com.secondhandcar.admin.utils.ShiroUtils;
import com.secondhandcar.core.utils.ToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Component
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private ShiroService shiroService;

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        log.info("开始认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = shiroService.user(token.getUsername());
        ShiroUser shiroUser = shiroService.shiroUser(user);
        SimpleAuthenticationInfo info = shiroService.info(shiroUser, user, super.getName());
        return info;
    }

    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("开始授权");
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        List<Integer> roleList = shiroUser.getRoleList();

        Set<String> permissionSet = new HashSet<>();
        Set<String> roleNameSet = new HashSet<>();

        for (Integer roleId : roleList) {
            List<String> permissions = shiroService.findPermissionsByRoleId(roleId);
            if (permissions != null) {
                for (String permission : permissions) {
                    if (ToolUtil.isNotEmpty(permission)) {
                        permissionSet.add(permission);
                    }
                }
            }
            String roleName = shiroService.findRoleNameByRoleId(roleId);
            roleNameSet.add(roleName);
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionSet);
        info.addRoles(roleNameSet);
        return info;
    }

    /**
     * 设置认证加密方式
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        log.info("开始设置认证加密方式");
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
        md5CredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
        super.setCredentialsMatcher(md5CredentialsMatcher);
    }
}