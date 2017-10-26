package com.secondhandcar.admin.service.impl;

import com.secondhandcar.admin.service.PermissionCheckService;
import com.secondhandcar.admin.utils.ShiroUser;
import com.secondhandcar.admin.utils.ShiroUtils;
import com.secondhandcar.core.listener.ConfigListener;
import com.secondhandcar.core.utils.CollectionUtils;
import com.secondhandcar.core.utils.HttpUtils;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiet on 2017/10/26.
 */
@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class PermissionCheckServiceImpl implements PermissionCheckService {
    @Override
    public boolean check(Object[] permissions) {
        ShiroUser user = ShiroUtils.getUser();
        if (null == user) {
            return false;
        }
        String join = CollectionUtils.join(permissions, ",");
        if (ShiroUtils.hasAnyRoles(join)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAll() {
        HttpServletRequest request = HttpUtils.getRequest();
        ShiroUser user = ShiroUtils.getUser();
        if (null == user) {
            return false;
        }
        String requestURI = request.getRequestURI().replaceFirst(ConfigListener.getConf().get("contextPath"), "");
        String[] str = requestURI.split("/");
        if (str.length > 3) {
            requestURI = "/" + str[1] + "/" + str[2];
        }
        if (ShiroUtils.hasPermission(requestURI)) {
            return true;
        }
        return false;
    }
}
