package com.secondhandcar.admin.aspect;

import com.secondhandcar.admin.service.PermissionCheckService;
import com.secondhandcar.core.annotion.Permission;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.naming.NoPermissionException;
import java.lang.reflect.Method;

/**
 * AOP 权限自定义检查
 */
@Aspect
@Component
public class PermissionAop {

    @Resource
    private PermissionCheckService permissionCheckService;

    @Pointcut(value = "@annotation(com.secondhandcar.core.annotion.Permission)")
    private void cutPermission() {

    }

    @Around("cutPermission()")
    public Object doPermission(ProceedingJoinPoint point) throws Throwable {
        MethodSignature ms = (MethodSignature) point.getSignature();
        Method method = ms.getMethod();
        Permission permission = method.getAnnotation(Permission.class);
        Object[] permissions = permission.value();
        if (permissions == null || permissions.length == 0) {
            //检查全体角色
            boolean result = permissionCheckService.checkAll();
            if (result) {
                return point.proceed();
            } else {
                throw new NoPermissionException();
            }
        } else {
            //检查指定角色
            boolean result = permissionCheckService.check(permissions);
            if (result) {
                return point.proceed();
            } else {
                throw new NoPermissionException();
            }
        }

    }

}